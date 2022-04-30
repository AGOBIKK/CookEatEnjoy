package com.agobikk.cookeatenjoy.ui.screens.ingredient

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.agobikk.cookeatenjoy.model.ExtendedIngredient


class IngredientListAdapter(private val onClickListener: IngredientListFragment.OnClickListener) :
   ListAdapter<ExtendedIngredient, IngredientListAdapter.IngredientViewHolder>(
        IngredientDiffUtil()
    ) {




    class IngredientViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientListAdapter.IngredientViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: IngredientListAdapter.IngredientViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }


}