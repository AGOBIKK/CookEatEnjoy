package com.agobikk.cookeatenjoy.ui.screens.favorite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.application.appComponent
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.databinding.FragmentDetailRecipeBinding
import com.agobikk.cookeatenjoy.databinding.FragmentFavoriteBinding
import com.agobikk.cookeatenjoy.databinding.FragmentListRecipeBinding
import com.agobikk.cookeatenjoy.ui.BaseFragment
import kotlinx.coroutines.*
import timber.log.Timber


class FavoriteFragment : BaseFragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val viewBinding get() = _binding!!

    private var adapter: FavoriteAdapter? = null
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
        init()

    }

    private  fun init() {
        adapter = FavoriteAdapter(object : OnFavoriteClickListener{
            override fun onClick(foodInformationEntity: FoodInformationEntity) {
                navigate()
            }
        })


        viewBinding.recipeFavoriteRecyclerView.adapter = adapter
        viewModel.getAllRecipe().observe(viewLifecycleOwner) {list ->
            adapter?.submitList(list.asReversed())
        }

    }


    private fun navigate() {
        findNavController().navigate(R.id.action_favorite_to_detailRecipeFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}