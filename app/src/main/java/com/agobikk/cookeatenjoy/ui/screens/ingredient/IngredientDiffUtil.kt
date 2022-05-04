package com.agobikk.cookeatenjoy.ui.screens.ingredient

import androidx.recyclerview.widget.DiffUtil
import com.agobikk.cookeatenjoy.model.ExtendedIngredient

class IngredientDiffUtil(
) : DiffUtil.ItemCallback<ExtendedIngredient>() {
    override fun areItemsTheSame(
        oldItem: ExtendedIngredient,
        newItem: ExtendedIngredient
    ) = oldItem === newItem

    override fun areContentsTheSame(
        oldItem: ExtendedIngredient,
        newItem: ExtendedIngredient
    ) = oldItem == newItem


}