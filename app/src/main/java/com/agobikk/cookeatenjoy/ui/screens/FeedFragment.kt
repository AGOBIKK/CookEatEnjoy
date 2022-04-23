package com.agobikk.cookeatenjoy.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentFeedBinding
import com.agobikk.cookeatenjoy.model.Category
import com.agobikk.cookeatenjoy.ui.adapters.CategoryAdapter
import com.agobikk.cookeatenjoy.ui.adapters.OnCategoryClick
import com.agobikk.cookeatenjoy.util.Const


class FeedFragment : Fragment(R.layout.fragment_feed) {
    private val viewBinding: FragmentFeedBinding by viewBinding()
    private lateinit var adapter: CategoryAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() = with(viewBinding) {

        recyclerView = categoryListRecyclerView
        adapter = CategoryAdapter(OnCategoryClick {  })
        recyclerView.adapter = adapter

        val categoryList: List<Category> = List(Const.DEFAULT_CATEGORIES_NAMES.size) { index ->
            Category(
                getString(Const.DEFAULT_CATEGORIES_NAMES[index]),
                Const.DEFAULT_CATEGORY_IMAGES[index]
            )
        }
        adapter.categoryData = categoryList
    }


}