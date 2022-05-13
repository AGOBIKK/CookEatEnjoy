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
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.databinding.FragmentDetailRecipeBinding
import com.agobikk.cookeatenjoy.model.ExtendedIngredient
import com.agobikk.cookeatenjoy.model.FoodInformation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout
import timber.log.Timber

class DetailRecipeFragment : Fragment(R.layout.fragment_detail_recipe) {
    private val viewBinding: FragmentDetailRecipeBinding by viewBinding()
    private val viewModel: DetailRecipeViewModel by viewModels()


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
        return arguments?.getInt(ID_FOOD_RECIPE_DETAIL) ?: 1
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

//                list?.body()?.ExtendedIngredient?.toMutableList()
                Timber.d("ExtendedIngredient--->>>>>>:${list?.body()?.extendedIngredient?.size}")
                Timber.d("ExtendedIngredient--->>>>>>:${list?.body()?.extendedIngredient}")
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
        Timber.d("setDetails:> ${arguments?.getString(ID_FOOD_RECIPE_DETAIL)}")
        sourceNameRecipe.text = detailRecipe.sourceName
        Timber.d("subscribeUi: ${arguments?.getString(ID_FOOD_RECIPE_DETAIL)}")
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
        Timber.d("subscribeUi: ${arguments?.getString(ID_FOOD_RECIPE_DETAIL)}")
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

    companion object {
        const val ID_FOOD_RECIPE_DETAIL = "ID_FOOD_RECIPE_DETAIL"

        var ingredientsList: MutableList<ExtendedIngredient> =
            MutableList(1) {
                ExtendedIngredient(1, 1.0, "", "", "", "", "")
            }
    }
}