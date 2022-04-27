package com.agobikk.cookeatenjoy.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.model.RecipeList
import com.agobikk.cookeatenjoy.ui.adapters.RecipesAdapter
import com.agobikk.cookeatenjoy.ui.viewmodels.RecipesViewModel


class RecipeListFragment : Fragment(R.layout.fragment_list_recipe) {
    private val viewBinding: FragmentListRecipeBinding by viewBinding()
    private lateinit var adapter: RecipesAdapter
    private val viewModel: RecipesViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RecipesAdapter(OnClickListener { navigateToRecipeList() })
        viewBinding.recipeListRecyclerView.adapter = adapter
        viewModel.recipeList.observe(viewLifecycleOwner) {
            it.let { adapter.submitList(it) }
        }

    }


    private fun navigateToRecipeList() {
        findNavController().navigate(R.id.action_RecipeListFragment_to_detailRecipeFragment)

    }

    class OnClickListener(val clickListener: (recipeList: RecipeList) -> Unit) {
        fun onClick(recipeList: RecipeList) = clickListener(recipeList)
    }
}

