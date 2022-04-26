package com.agobikk.cookeatenjoy.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.ui.adapters.OnRecipeClick
import com.agobikk.cookeatenjoy.ui.adapters.RecipeListAdapter
import com.agobikk.cookeatenjoy.ui.viewmodels.RecipesViewModel


class RecipeListFragment : Fragment(R.layout.fragment_list_recipe) {
    private val viewBinding: FragmentListRecipeBinding by viewBinding()
    private lateinit var adapter: RecipeListAdapter


    private lateinit var viewModel: RecipesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerList()

    }

    private fun initRecyclerList() = with(viewBinding) {
        adapter = RecipeListAdapter(OnRecipeClick { recipeId -> setRecipeId(recipeId) })
        recipeListRecyclerView.adapter = adapter
        adapter.recipeListData
    }


    private fun setRecipeId(recipeId: String) {
        // навигация через findNavController в  detail
    }


}