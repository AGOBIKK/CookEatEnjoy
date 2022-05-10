package com.agobikk.cookeatenjoy.ui.screens.ingredient

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentListIngredientBinding
import com.agobikk.cookeatenjoy.model.ExtendedIngredient

class IngredientListFragment : Fragment(R.layout.fragment_list_ingredient) {
    private val viewBinding: FragmentListIngredientBinding by viewBinding()
    private lateinit var adapter: IngredientListAdapter
    private val viewModel: IngredientViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        init()


        /**'
         * Временное решение для иницилизации списка, после того как данные будут приходить по сети удалить!!!
         */
        val Ing1 = ExtendedIngredient(1.00, "consistency", "image", "name", "original", "unit")
        val Ing2 = ExtendedIngredient(2.00, "consistency", "image", "name", "original", "unit")
        val Ing3 = ExtendedIngredient(12.00, "consistency", "image", "name", "original", "unit")
        val Ing4 = ExtendedIngredient(14.00, "consistency", "image", "name", "original", "unit")
        adapter.submitList(listOf(Ing1, Ing1, Ing2, Ing3, Ing4))
    }

    private fun init() = with(viewBinding) {
        adapter = IngredientListAdapter(object : OnIngredientClickListener {
            override fun onClick(extendedIngredient: ExtendedIngredient) {

            }
        })
        viewBinding.ingredientsRecyclerview.adapter = adapter
    }

}


