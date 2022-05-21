package com.agobikk.cookeatenjoy.ui.screens.recipe

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.model.ResultMainCourse
import com.agobikk.cookeatenjoy.ui.screens.category.ChooseCategoryDish


class RecipeListFragment() : Fragment(R.layout.fragment_list_recipe) {
    private val viewBinding: FragmentListRecipeBinding by viewBinding()
    private var adapter: RecipesAdapter? = null
    private val viewModel: RecipesViewModel by viewModels()
    private var isFirst = true


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        init()
    }

    private fun init() {
        if (isFirst ) {
            adapter = RecipesAdapter(object : OnClickListener {
                override fun onClick(resultMainCourse: ResultMainCourse) {
                    navigateToRecipeList(resultMainCourse.id)
                }
            })
        }
        viewBinding.recipeListRecyclerView.adapter = adapter
        if (isFirst) {
            viewModel.onViewCreated(typeOfDish = ChooseCategoryDish.chooseDishOfType)
            isFirst = false
            viewModel.recipeList.observe(viewLifecycleOwner) { list ->
                adapter?.submitList(list?.body()?.results)
            }
        }
    }

    private fun navigateToRecipeList(value: Long) {
        val direction =
            RecipeListFragmentDirections.actionRecipeListFragmentToDetailRecipeFragment(value)
        findNavController()
            .navigate(direction)
    }
}





