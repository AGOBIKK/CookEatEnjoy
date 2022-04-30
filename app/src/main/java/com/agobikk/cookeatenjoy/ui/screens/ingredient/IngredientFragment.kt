package com.agobikk.cookeatenjoy.ui.screens.ingredient

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.FragmentIngredientBinding
import com.agobikk.cookeatenjoy.model.ExtendedIngredient


class IngredientFragment : Fragment(R.layout.fragment_ingredient) {
    private val viewBinding: FragmentIngredientBinding by viewBinding()
    private lateinit var adapter: IngredientListAdapter
    private val viewModel: IngredientViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}


class OnClickListener(val clickListener: (ingredientList: ExtendedIngredient) -> Unit) {
    fun onClick(ingredientList: ExtendedIngredient) = clickListener(ingredientList)
}