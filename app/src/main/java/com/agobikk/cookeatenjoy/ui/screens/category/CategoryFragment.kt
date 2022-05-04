package com.agobikk.cookeatenjoy.ui.screens.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentCategoryBinding
import com.agobikk.cookeatenjoy.model.Category
import com.agobikk.cookeatenjoy.ui.adapters.CategoryAdapter
import com.agobikk.cookeatenjoy.ui.adapters.OnCategoryClick
import com.agobikk.cookeatenjoy.util.Const


class CategoryFragment : Fragment(R.layout.fragment_category) {
    private val viewBinding: FragmentCategoryBinding by viewBinding()
    private lateinit var adapter: CategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() = with(viewBinding) {
        adapter = CategoryAdapter(OnCategoryClick {  navigateToRecipeList() })
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
        findNavController().navigate(R.id.action_categoryFragment_to_recipeListFragment)

    }
}