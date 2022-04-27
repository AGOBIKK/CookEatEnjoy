package com.agobikk.cookeatenjoy.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.ui.adapters.OnRecipeClick
import com.agobikk.cookeatenjoy.ui.adapters.RecipeListAdapter


class RecipeListFragment : Fragment(R.layout.fragment_list_recipe) {
    private val viewBinding: FragmentListRecipeBinding by viewBinding()
    private lateinit var adapter: RecipeListAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView()  = with(viewBinding) {

        recyclerView = recipeListRecyclerView
        adapter = RecipeListAdapter(OnRecipeClick { recipeId -> setRecipeId(recipeId) })
    }

    private fun setRecipeId(recipeId: String) {
        // навигация
    }
}