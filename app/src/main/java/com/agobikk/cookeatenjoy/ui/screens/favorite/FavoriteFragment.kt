package com.agobikk.cookeatenjoy.ui.screens.favorite

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.agobikk.cookeatenjoy.application.appComponent
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.databinding.FragmentFavoriteBinding
import com.agobikk.cookeatenjoy.ui.BaseFragment


class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {
    private var adapter: FavoriteAdapter? = null
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onAttach(context: Context) {
        appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        init()
        navigateUP()
    }

    private fun init() {
        adapter = FavoriteAdapter(object : OnFavoriteClickListener {
            override fun onClick(favoriteRecipeEntity: FavoriteRecipeEntity) {
                navigateToDetailRecipeFragment(favoriteRecipeEntity.id)
            }
        })

        binding.recipeFavoriteRecyclerView.adapter = adapter
        viewModel.readAllRecipe().observe(viewLifecycleOwner) { response ->
            adapter?.submitList(response.asReversed())
        }
    }

    private fun navigateToDetailRecipeFragment(value: Long) {
        val direction =
            FavoriteFragmentDirections.actionFavoriteToDetailRecipeFragment(value)
        findNavController()
            .navigate(direction)
    }

    private fun navigateUP() {
        with(binding) {
            includeLayoutDetailIcon.recipeDetailCloseIcon.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

}