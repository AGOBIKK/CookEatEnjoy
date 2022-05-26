package com.agobikk.cookeatenjoy.ui.screens.favorite

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.models.ResultMainCourse


class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private val viewBinding: FragmentListRecipeBinding by viewBinding()
    private var adapter: FavoriteAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        init()
    }

    private fun init() {
        adapter = FavoriteAdapter(object : OnFavoriteClickListener {
            override fun onClick(resultMainCourse: ResultMainCourse) {
                navigate()
            }
        })
        viewBinding.recipeListRecyclerView.adapter = adapter
    }


    private fun navigate() {
        findNavController().navigate(R.id.action_categoryFragment_to_recipeListFragment)
    }
}