package com.agobikk.cookeatenjoy.ui.screens.detail

import android.content.Context
import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.text.parseAsHtml
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.SaveShared
import com.agobikk.cookeatenjoy.application.appComponent
import com.agobikk.cookeatenjoy.data.converters.ExtendedIngredientImpl
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.databinding.FragmentDetailRecipeBinding
import com.agobikk.cookeatenjoy.models.FoodInformation
import com.agobikk.cookeatenjoy.ui.BaseFragment
import com.agobikk.cookeatenjoy.util.Const.FAVORITE_BTN_IS_ACTIVE
import com.agobikk.cookeatenjoy.util.Const.FAVORITE_BTN_NOT_ACTIVE
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout
import kotlinx.coroutines.*
import timber.log.Timber

class DetailRecipeFragment : BaseFragment() {
    private var _binding: FragmentDetailRecipeBinding? = null
    private val viewBinding get() = _binding!!
    private val args: DetailRecipeFragmentArgs by navArgs()
    private var isFavorite = false
    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable -> Timber.d("throwable:$throwable") }
    private val scope =
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler + SupervisorJob())
    private val viewModel: DetailRecipeViewModel by viewModels()

    override fun onAttach(context: Context) {
        appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailRecipeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        val foodId = getFoodId()
        viewModel.onViewCreated(id = foodId)
        setScrollListener()
        subscribeUi()
        navigate(foodId)
    }

    private fun getFoodId(): Long {
        return args.idFood
    }

    private fun setScrollListener() = with(viewBinding) {
        val appBarLayout = recipeDetailAppBarLayout
        val offsetChangedListener = AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            Timber.i("setScrollListener: " + verticalOffset + " " + "\n" + "range:  " + appBarLayout.totalScrollRange)
            val seekPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            recipeDetailMotionLayout.progress = seekPosition
        }
        appBarLayout.addOnOffsetChangedListener(offsetChangedListener)
    }

    private fun subscribeUi() {
        viewModel.recipeDetail.observe(viewLifecycleOwner) { it ->
            it?.body()?.let { foodInformation ->
                setDetails(foodInformation)
            }
            viewModel.recipeDetail.observe(viewLifecycleOwner) { list ->
                val body = list?.body()
                val converter = ExtendedIngredientImpl()
                val ingredients =
                    list?.body()?.extendedIngredient?.map { converter.convert(it) } ?: emptyList()
                val foodInformation = FoodInformationEntity(
                    id = body?.id ?: 1,
                    image = body?.image ?: "",
                    instructions = body?.instructions ?: "",
                    title = body?.title ?: "",
                    sourceName = body?.sourceName ?: "",
                    extendedIngredientEntity = ingredients
                )
                viewModel.insert(foodInformation)
                fun updateBtnFavoriteIsNotActive() {
                    viewBinding.includeLayoutDetailIcon.recipeDetailFavoriteIcon.setImageResource(
                        FAVORITE_BTN_NOT_ACTIVE
                    )
                }

                fun updateBtnFavoriteIsActive() {
                    viewBinding.includeLayoutDetailIcon.recipeDetailFavoriteIcon.setImageResource(
                        FAVORITE_BTN_IS_ACTIVE
                    )
                }

                fun saveStateFavoriteValue(boolean: Boolean) {
                    SaveShared.setFavorite(requireContext(), foodInformation.id.toString(), boolean)
                }

                fun getStateFavoriteButtonBoolean(string: String): Boolean {
                    return SaveShared.getFavorite(requireContext(), string)
                }

                val valueBool = getStateFavoriteButtonBoolean(foodInformation.id.toString())

                fun updateFavoriteButton(isFavorite: Boolean, valueBool: Boolean) {
                    when {
                        isFavorite != valueBool -> updateBtnFavoriteIsActive()
                        else -> updateBtnFavoriteIsNotActive()
                    }
                }

                updateFavoriteButton(isFavorite, valueBool)

                viewBinding.includeLayoutDetailIcon.recipeDetailFavoriteIcon.setOnClickListener {
                    isFavorite = if (!isFavorite) {
                        updateBtnFavoriteIsActive()
                        saveStateFavoriteValue(true)
                        viewModel.insert(foodInformation)
                        true
                    } else {
                        updateBtnFavoriteIsNotActive()
                        saveStateFavoriteValue(false)
                        viewModel.delete(listOf(foodInformation))
                        false
                    }
                }
            }
        }
    }


    private fun setDetails(detailRecipe: FoodInformation) = with(viewBinding) {
        context?.let {
            Glide.with(it)
                .setDefaultRequestOptions(
                    RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image)
                )
                .load(detailRecipe.image)
                .into(recipeDetailImage)
        }
        recipeDetailTitle.text = detailRecipe.title
        sourceNameRecipe.text = detailRecipe.sourceName
        wordProcessing(detailRecipe)
    }

    private fun wordProcessing(detailRecipe: FoodInformation) = with(viewBinding) {
        includeLayoutCardInstruction.cookingInstructions.text =
            detailRecipe
                .instructions
                .parseAsHtml(HtmlCompat.TO_HTML_PARAGRAPH_LINES_CONSECUTIVE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                includeLayoutCardInstruction.cookingInstructions.justificationMode =
                    JUSTIFICATION_MODE_INTER_WORD
            }
        }
    }

    private fun navigate(value: Long) {
        with(viewBinding) {
            includeLayoutDetailIcon.recipeDetailCloseIcon.setOnClickListener {
                findNavController()
                    .navigateUp()
            }
            ingredientImage.setOnClickListener {
                val direction =
                    DetailRecipeFragmentDirections.actionDetailRecipeFragmentToIngredientFragment(
                        value
                    )

                findNavController()
                    .navigate(direction)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()

    }
}