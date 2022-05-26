package com.agobikk.cookeatenjoy.ui.screens.favorite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.aplication.appComponent
import com.agobikk.cookeatenjoy.databinding.FragmentFavoriteBinding
import com.agobikk.cookeatenjoy.ui.BaseFragment
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeViewModel
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipesAdapter


class FavoriteFragment : BaseFragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val viewBinding get() = _binding!!
    private var adapter: RecipesAdapter? = null
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onAttach(context: Context) {
        appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
//        init()
    }

//    private fun init() {
//        adapter = RecipesAdapter(object : OnClickListener {
//            override fun onClick(resultMainCourse: ResultMainCourse) {
//                navigate()
//            }
//        })
//        viewBinding.recipeListRecyclerView.adapter = adapter
//    }


    private fun navigate() {
        findNavController().navigate(R.id.action_categoryFragment_to_recipeListFragment)
    }
}