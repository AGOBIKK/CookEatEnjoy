package com.agobikk.cookeatenjoy.ui.screens.ingredient

import androidx.recyclerview.widget.DiffUtil
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity

class IngredientDiffUtil(
) : DiffUtil.ItemCallback<ExtendedIngredientEntity>() {
    override fun areItemsTheSame(
        oldItem: ExtendedIngredientEntity,
        newItem: ExtendedIngredientEntity
    ) = oldItem === newItem

    override fun areContentsTheSame(
        oldItem: ExtendedIngredientEntity,
        newItem: ExtendedIngredientEntity
    ) = oldItem == newItem


}