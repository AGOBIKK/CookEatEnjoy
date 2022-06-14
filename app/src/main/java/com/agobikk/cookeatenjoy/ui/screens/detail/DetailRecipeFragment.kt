package com.agobikk.cookeatenjoy.ui.screens.detail

import android.content.Context
import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.TO_HTML_PARAGRAPH_LINES_CONSECUTIVE
import androidx.core.text.parseAsHtml
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.SaveShared
import com.agobikk.cookeatenjoy.application.appComponent
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.databinding.FragmentDetailRecipeBinding
import com.agobikk.cookeatenjoy.ui.BaseFragment
import com.agobikk.cookeatenjoy.util.Const.FAVORITE_BTN_IS_ACTIVE
import com.agobikk.cookeatenjoy.util.Const.FAVORITE_BTN_NOT_ACTIVE
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout
import kotlinx.coroutines.*
import timber.log.Timber

class DetailRecipeFragment :
    BaseFragment<FragmentDetailRecipeBinding>(FragmentDetailRecipeBinding::inflate) {
    private val args: DetailRecipeFragmentArgs by navArgs()
    private var isFavorite = false
    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable -> Timber.d("throwable:$throwable") }
    private val scope =
        CoroutineScope(Dispatchers.Main + coroutineExceptionHandler + SupervisorJob())
    private val viewModel: DetailRecipeViewModel by viewModels()
    private fun readFoodById(): Long {
        return args.idFood
    }

    override fun onAttach(context: Context) {
        appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayHomeUp(false)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        viewModel.onViewCreated(id = readFoodById())
        setScrollListener()
        subscribeUi()
        navigate(readFoodById())
    }


    private fun setScrollListener() = with(binding) {
        val appBarLayout = recipeDetailAppBarLayout
        val offsetChangedListener = AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            recipeDetailMotionLayout.progress = seekPosition
        }
        appBarLayout.addOnOffsetChangedListener(offsetChangedListener)
    }

    private fun subscribeUi() {
        viewModel.recipeDetail.observe(viewLifecycleOwner) {
            it?.let { foodInformation ->
                setDetails(foodInformation)
            }
        }

        viewModel.recipeDetail.observe(viewLifecycleOwner) { response ->

            fun updateBtnFavoriteIsNotActive() {
                binding.includeLayoutDetailIcon.recipeDetailFavoriteIcon.setImageResource(
                    FAVORITE_BTN_NOT_ACTIVE
                )
            }

            fun updateBtnFavoriteIsActive() {
                binding.includeLayoutDetailIcon.recipeDetailFavoriteIcon.setImageResource(
                    FAVORITE_BTN_IS_ACTIVE
                )
            }

            fun saveStateFavoriteValue(boolean: Boolean) {
                SaveShared.setFavorite(requireContext(), readFoodById().toString(), boolean)
            }

            fun getStateFavoriteButtonBoolean(string: String): Boolean {
                return SaveShared.getFavorite(requireContext(), string)
            }

            val valueBool = getStateFavoriteButtonBoolean(readFoodById().toString())

            fun updateFavoriteButton(isFavorite: Boolean, valueBool: Boolean) {
                when {
                    isFavorite != valueBool -> updateBtnFavoriteIsActive()
                    else -> updateBtnFavoriteIsNotActive()
                }
            }

            binding.includeLayoutDetailIcon.recipeDetailFavoriteIcon.setOnClickListener {
                val body = checkNotNull(response)
                val favoriteRecipe =
                    FavoriteRecipeEntity(readFoodById(), body.image, body.title)
                isFavorite = if (!isFavorite) {
                    updateBtnFavoriteIsActive()
                    saveStateFavoriteValue(true)
                    viewModel.insertFavoriteRecipe(favoriteRecipe)
                    true
                } else {
                    updateBtnFavoriteIsNotActive()
                    saveStateFavoriteValue(false)
                    viewModel.deleteFavoriteRecipe(favoriteRecipe)
                    false
                }
            }
            updateFavoriteButton(isFavorite, valueBool)
        }
    }

    private fun setDetails(detailRecipe: FoodInformationEntity) = with(binding) {
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
        shareRecipe(detailRecipe)
    }

    private fun shareRecipe(shareRecipe: FoodInformationEntity) {
        binding.includeLayoutDetailIcon.recipeDetailShareIcon.setOnClickListener {
            val shareText = StringBuilder()
                .append(resources.getString(R.string.check_this_recipe) + "\n")
                .append("${shareRecipe.title}\n\n")
                .append("${shareRecipe.sourceName}\n\n")
                .append("${shareRecipe.image}\n\n")
                .append("${shareRecipe.instructions?.parseAsHtml(TO_HTML_PARAGRAPH_LINES_CONSECUTIVE)}\n\n")
            val intent = requireActivity().let {
                ShareCompat.IntentBuilder(it)
                    .setText(shareText.toString())
                    .setType("text/plain")
                    .intent
            }
            startActivity(intent)
        }

    }

    private fun wordProcessing(detailRecipe: FoodInformationEntity) = with(binding) {
        includeLayoutCardInstruction.cookingInstructions.text =
            detailRecipe.instructions?.parseAsHtml(HtmlCompat.TO_HTML_PARAGRAPH_LINES_CONSECUTIVE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                includeLayoutCardInstruction.cookingInstructions.justificationMode =
                    JUSTIFICATION_MODE_INTER_WORD
            }
        }
    }

    private fun navigate(value: Long) {
        with(binding) {
            includeLayoutDetailIcon.recipeDetailCloseIcon.setOnClickListener {
                findNavController().navigateUp()
            }
            ingredientImage.setOnClickListener {
                val direction = DetailRecipeFragmentDirections
                    .actionDetailRecipeFragmentToIngredientFragment(value)
                findNavController().navigate(direction)
            }
        }
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}