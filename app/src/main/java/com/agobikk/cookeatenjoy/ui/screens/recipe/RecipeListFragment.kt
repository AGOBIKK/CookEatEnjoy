package com.agobikk.cookeatenjoy.ui.screens.recipe

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.application.appComponent
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.models.ResultMainCourse
import com.agobikk.cookeatenjoy.ui.BaseFragment
import timber.log.Timber


class RecipeListFragment :
    BaseFragment<FragmentListRecipeBinding>(FragmentListRecipeBinding::inflate) {
    private var adapter: RecipesAdapter? = null
    private var isFirst = true
    private val viewModel: RecipesViewModel by viewModels()

    override fun onAttach(context: Context) {
        appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        displayHomeUp(true)
        init()
    }

    private fun init() {
        if (isFirst) {
            adapter = RecipesAdapter(object : OnClickListener {
                override fun onClick(resultMainCourse: ResultMainCourse) {
                    navigateToRecipeList(resultMainCourse.id)
                }
            })
            viewModel.onViewCreated()
            isFirst = false
            adapter?.let { viewModel.updateListRecipeInformation(viewLifecycleOwner, it) }
        }
        binding.recipeListRecyclerView.adapter = adapter
    }

    private fun displayHomeUp(show: Boolean) {
        requireActivity().run {
            (this as AppCompatActivity).supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            supportActionBar?.setCustomView(R.layout.custom_toolbar_recipe_fragment)
        }
    }

    private fun navigateToRecipeList(value: Long) {
        val direction =
            RecipeListFragmentDirections.actionRecipeListFragmentToDetailRecipeFragment(value)
        findNavController()
            .navigate(direction)
    }
}





