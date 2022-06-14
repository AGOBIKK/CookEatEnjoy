package com.agobikk.cookeatenjoy.ui.screens.category

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentCategoryBinding
import com.agobikk.cookeatenjoy.models.Category
import com.agobikk.cookeatenjoy.ui.BaseFragment
import com.agobikk.cookeatenjoy.util.Const
import com.google.android.material.bottomnavigation.BottomNavigationView


class CategoryFragment : BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate) {
    private lateinit var adapter: CategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayHomeUp(false)
        initRecyclerView()
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.mainBottomNavigationView)
        navBar.visibility = View.VISIBLE
    }

    private fun initRecyclerView() = with(binding) {
        adapter = CategoryAdapter(object : OnCategoryClickListener {
            override fun onClick(category: Category) {
                navigateToRecipeList()
            }
        })
        categoryListRecyclerView.adapter = adapter

        val categoryList: List<Category> = List(Const.DEFAULT_CATEGORIES_NAMES.size) { index ->
            Category(
                getString(Const.DEFAULT_CATEGORIES_NAMES[index]),
                Const.DEFAULT_CATEGORY_IMAGES[index]
            )
        }
        adapter.categoryData = categoryList
    }

    private fun navigateToRecipeList() {
        findNavController().navigate(R.id.action_CategoryFragment_to_RecipeListFragment)
    }
}