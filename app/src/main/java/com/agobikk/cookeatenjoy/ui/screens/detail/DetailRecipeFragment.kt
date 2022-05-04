package com.agobikk.cookeatenjoy.ui.screens.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentDetailRecipeBinding
import com.agobikk.cookeatenjoy.model.DetailRecipe
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout

class DetailRecipeFragment : Fragment(R.layout.fragment_detail_recipe) {
    private val viewBinding: FragmentDetailRecipeBinding by viewBinding()
    private val viewModel: DetailRecipeViewModel by viewModels()
    lateinit var mDetailRecipe: DetailRecipe
    private var isFavorite: Boolean = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        setScrollListener()
        subscribeUi()
        with(viewBinding) {
            includeLayoutDetailIcon.recipeDetailCloseIcon.setOnClickListener { findNavController().navigateUp() }
            ingredientImage.setOnClickListener { findNavController().navigate(R.id.action_detailRecipeFragment_to_ingredientFragment) }
        }
    }

    private fun setScrollListener() = with(viewBinding) {
        val appBarLayout = recipeDetailAppBarLayout
        val offsetChangedListener = AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            Log.i(
                "DetailRecipeFragment",
                "setScrollListener: $verticalOffset \nrange:  ${appBarLayout.totalScrollRange}"
            )
            val seekPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            recipeDetailMotionLayout.progress = seekPosition
        }
        appBarLayout.addOnOffsetChangedListener(offsetChangedListener)
    }

    private fun subscribeUi() {
        viewModel.recipeDetail.observe(viewLifecycleOwner) {
            it?.let {
                Log.i("DetailRecipeFragment", "subscribeUi: $it")
                setDetails(it)
            }
        }
    }

    private fun setDetails(detailRecipe: DetailRecipe) = with(viewBinding) {
        Glide.with(requireContext())
            .setDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .load(detailRecipe.imageUrl)
            .into(recipeDetailImage)
        recipeDetailTitle.text = detailRecipe.title
        sourceNameRecipe.text = detailRecipe.sourceName
        instructions.text = detailRecipe.instructions
    }
}