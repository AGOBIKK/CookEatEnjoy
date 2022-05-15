package com.agobikk.cookeatenjoy.ui.screens.detail

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.text.parseAsHtml
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.aplication.App
import com.agobikk.cookeatenjoy.databinding.FragmentDetailRecipeBinding
import com.agobikk.cookeatenjoy.model.ExtendedIngredient
import com.agobikk.cookeatenjoy.model.FoodInformation

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.coroutineContext

class DetailRecipeFragment : Fragment(R.layout.fragment_detail_recipe) {
    private val viewBinding: FragmentDetailRecipeBinding by viewBinding()
    private val viewModel: DetailRecipeViewModel by viewModels()
    private val args: DetailRecipeFragmentArgs by navArgs()
    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable -> Timber.d("throwable:$throwable") }
    private val scope =
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler + SupervisorJob())
    private var job: Job? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        val foodId = getFoodId()
        viewModel.onViewCreated(id = foodId)

        setScrollListener()
        subscribeUi()
        navigate()


    }

    private fun getFoodId(): Int {
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
        viewModel.recipeDetail.observe(viewLifecycleOwner) {
            it?.body()?.let { foodInformation ->
                Timber.i("subscribeUi: $it")
                setDetails(foodInformation)
            }
            viewModel.recipeDetail.observe(viewLifecycleOwner) { list ->


                Timber.d("ExtendedIngredient--->>>>>>:${list?.body()?.extendedIngredient}")

                val ingredient =
                    com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredient(
                        idExtendedIngredient =  list?.body()?.extendedIngredient?.get(0)?.idExtendedIngredient ?: 0,
                        amount = list?.body()?.extendedIngredient?.get(1)?.amount ?: 0.0,
                        consistency = list?.body()?.extendedIngredient?.get(2)?.consistency ?: "not info",
                        image_ingredient = list?.body()?.extendedIngredient?.get(3)?.image ?: "not info",
                        name = list?.body()?.extendedIngredient?.get(4)?.name ?: "not info",
                        original = list?.body()?.extendedIngredient?.get(5)?.original ?: "not info",
                        unit = list?.body()?.extendedIngredient?.get(6)?.unit ?: "not info"
                    )
                val foodInformation = com.agobikk.cookeatenjoy.data.local.entities.FoodInformation(
                    id = list?.body()?.id ?: 1,
                    image = list?.body()?.image ?: "image_food_url",
                    instructions = list?.body()?.instructions ?: "instructions",
                    title = list?.body()?.title ?: "title",
                    sourceName = list?.body()?.sourceName ?: "sourceName",
                    extendedIngredient = ingredient
                )

                job?.cancel()
                job = scope.launch {
                    App
                        .instance
                        .databaseService
                        .getFoodInformation()
                        .insertFoodInfo(foodInformation)

                    Timber.d(
                        "VVV:${App.instance.databaseService.getFoodInformation().searchFoodById(getFoodId())}"
                    )
                }

                ingredientsList = list?.body()?.extendedIngredient?.toMutableList()!!
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

    private fun navigate() {
        with(viewBinding) {
            includeLayoutDetailIcon.recipeDetailCloseIcon.setOnClickListener {
                findNavController()
                    .navigateUp()
            }
            ingredientImage.setOnClickListener {
                findNavController()
                    .navigate(
                        R.id.action_detailRecipeFragment_to_ingredientFragment
                    )
            }
        }
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()

    }

    companion object {


        var ingredientsList: MutableList<ExtendedIngredient> =
            MutableList(1) {
                ExtendedIngredient(1, 1.0, "", "", "", "", "")
            }
    }
}