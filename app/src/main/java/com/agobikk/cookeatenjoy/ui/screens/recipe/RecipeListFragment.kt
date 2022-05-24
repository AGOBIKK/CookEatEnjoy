package com.agobikk.cookeatenjoy.ui.screens.recipe

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.aplication.App
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.models.ResultMainCourse
import com.agobikk.cookeatenjoy.ui.screens.category.ChooseCategoryDish
import javax.inject.Inject


class RecipeListFragment : Fragment(R.layout.fragment_list_recipe) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewBinding: FragmentListRecipeBinding by viewBinding()
    private var adapter: RecipesAdapter? = null
    private var isFirst = true
    lateinit var viewModel: RecipesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[RecipesViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        init()
    }

    private fun init() {
        if (isFirst) {
            adapter = RecipesAdapter(object : OnClickListener {
                override fun onClick(resultMainCourse: ResultMainCourse) {
                    navigateToRecipeList(resultMainCourse.id)
                }
            })
        }
        viewBinding.recipeListRecyclerView.adapter = adapter
        if (isFirst) {
            viewModel.onViewCreated()
            isFirst = false
            adapter?.let { viewModel.updateListRecipeInformation(viewLifecycleOwner, it) }
        }
    }
    private fun navigateToRecipeList(value: Long) {
        val direction =
            RecipeListFragmentDirections.actionRecipeListFragmentToDetailRecipeFragment(value)
        findNavController()
            .navigate(direction)
    }
}





