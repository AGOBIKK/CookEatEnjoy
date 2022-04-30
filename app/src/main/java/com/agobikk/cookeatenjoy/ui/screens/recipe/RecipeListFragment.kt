package com.agobikk.cookeatenjoy.ui.screens.recipe

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.agobikk.cookeatenjoy.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.model.RecipeList
import com.agobikk.cookeatenjoy.ui.viewmodels.RecipesViewModel


class RecipeListFragment : Fragment(R.layout.fragment_list_recipe) {
    private val viewBinding: FragmentListRecipeBinding by viewBinding()
    private lateinit var adapter: RecipesAdapter
    private val viewModel: RecipesViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RecipesAdapter(OnClickListener { navigateToRecipeList() })
        viewBinding.recipeListRecyclerView.adapter = adapter

        //сейчас тут нет данных т.к. еще не приходят  данные из сети
        viewModel.recipeList.observe(viewLifecycleOwner) {
            it.let { adapter.submitList(it) }
        }

        /**'
         * Временное решение для иницилизации списка, после того как данные будут приходить по сети
         * Это удалить  и будет применено
         */

        val p1 = RecipeList("1", "2","4", 22F,"")
        val p2 = RecipeList("1", "2","4", 10F,"")
        val p3 = RecipeList("1", "2","4", 40F,"")
        val p4 = RecipeList("1", "2","4", 40F,"")
        val p5 = RecipeList("1", "2","4", 40F,"")
        val p6 = RecipeList("1", "2","4", 40F,"")
        val p7 = RecipeList("1", "2","4", 40F,"")
        adapter.submitList(listOf(p1,p2,p3,p4,p5,p6,p7))

    }

    private fun navigateToRecipeList() {
        findNavController().navigate(R.id.action_RecipeListFragment_to_detailRecipeFragment)

    }

    class OnClickListener(val clickListener: (recipeList: RecipeList) -> Unit) {
        fun onClick(recipeList: RecipeList) = clickListener(recipeList)
    }
}

