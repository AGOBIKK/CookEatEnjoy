package com.agobikk.cookeatenjoy.ui.screens.recipe

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.model.ResultMainCourse


class RecipeListFragment : Fragment(R.layout.fragment_list_recipe) {
    private val viewBinding: FragmentListRecipeBinding by viewBinding()
    private lateinit var adapter: RecipesAdapter
    private val viewModel: RecipesViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        adapter = RecipesAdapter(OnClickListener { navigateToRecipeList() })
        viewBinding.recipeListRecyclerView.adapter = adapter
        viewModel.getModelMainCourse()

        //сейчас тут нет данных т.к. еще не приходят  данные из сети
        viewModel.recipeList.observe(viewLifecycleOwner) {list ->
            adapter.submitList(list!!.body()!!.results) }
        }
    private fun navigateToRecipeList() {
        findNavController().navigate(R.id.action_RecipeListFragment_to_detailRecipeFragment)

    }

    class OnClickListener(val clickListener: (recipeList: ResultMainCourse) -> Unit) {
        fun onClick(recipeList: ResultMainCourse) = clickListener(recipeList)
    }
}

