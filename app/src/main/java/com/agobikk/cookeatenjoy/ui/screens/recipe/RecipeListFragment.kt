package com.agobikk.cookeatenjoy.ui.screens.recipe

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.aplication.App
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.models.ResultMainCourse
import com.agobikk.cookeatenjoy.ui.BaseFragment
import com.agobikk.cookeatenjoy.ui.screens.category.ChooseCategoryDish
import timber.log.Timber
import javax.inject.Inject


class RecipeListFragment :BaseFragment() {

    private val viewBinding: FragmentListRecipeBinding by viewBinding()
    lateinit var adapter: RecipesAdapter
    private var isFirst = true
    private val viewModel: RecipesViewModel by viewModels()

    override fun onAttach(context: Context) {
        App.instance.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        Timber.d("-------------some.value:${viewModel.some.value}")
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
            adapter.let { viewModel.updateListRecipeInformation(viewLifecycleOwner, it) }
        }
    }
    private fun navigateToRecipeList(value: Long) {
        val direction =
            RecipeListFragmentDirections.actionRecipeListFragmentToDetailRecipeFragment(value)
        findNavController()
            .navigate(direction)
    }
}





