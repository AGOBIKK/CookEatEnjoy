package com.agobikk.cookeatenjoy.ui.screens.ingredient

import android.os.Bundle
import android.view.View
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
        adapter = IngredientListAdapter(OnClickListener {})
        viewBinding.ingredientsRecyclerview.adapter = adapter


        /**'
         * Временное решение для иницилизации списка, после того как данные будут приходить по сети удалить!!!
         *
         */

        val Ing1 = ExtendedIngredient(1.00, "consistency", "image", "name", "original", "unit")
        val Ing2 = ExtendedIngredient(2.00, "consistency", "image", "name", "original", "unit")
        val Ing3 = ExtendedIngredient(12.00, "consistency", "image", "name", "original", "unit")
        val Ing4 = ExtendedIngredient(14.00, "consistency", "image", "name", "original", "unit")
        val Ing5 = ExtendedIngredient(15.00, "consistency", "image", "name", "original", "unit")
        val Ing6 = ExtendedIngredient(12.00, "consistency", "image", "name", "original", "unit")
        val Ing7 = ExtendedIngredient(12.00, "consistency", "image", "name", "original", "unit")
        val Ing8 = ExtendedIngredient(11.00, "consistency", "image", "name", "original", "unit")
        val Ing9 = ExtendedIngredient(12.00, "consistency", "image", "name", "original", "unit")
        val Ing10 = ExtendedIngredient(51.00, "consistency", "image", "name", "original", "unit")
        val Ing11 = ExtendedIngredient(12.00, "consistency", "image", "name", "original", "unit")
        val Ing12 = ExtendedIngredient(16.00, "consistency", "image", "name", "original", "unit")
        val Ing13 = ExtendedIngredient(12.00, "consistency", "image", "name", "original", "unit")
        val Ing14 = ExtendedIngredient(18.00, "consistency", "image", "name", "original", "unit")
        adapter.submitList(
            listOf(
                Ing1,
                Ing1,
                Ing2,
                Ing3,
                Ing4,
                Ing5,
                Ing6,
                Ing7,
                Ing8,
                Ing9,
                Ing10,
                Ing11,
                Ing12,
                Ing13,
                Ing14
            )
        )
    }


    class OnClickListener(val clickListener: (ingredientList: ExtendedIngredient) -> Unit) {
        fun onClick(ingredientList: ExtendedIngredient) = clickListener(ingredientList)
    }
}


