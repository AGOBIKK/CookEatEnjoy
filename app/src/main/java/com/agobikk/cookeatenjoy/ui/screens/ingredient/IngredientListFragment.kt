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
    }


    class OnClickListener(val clickListener: (ingredientList: ExtendedIngredient) -> Unit) {
        fun onClick(ingredientList: ExtendedIngredient) = clickListener(ingredientList)
    }
}


