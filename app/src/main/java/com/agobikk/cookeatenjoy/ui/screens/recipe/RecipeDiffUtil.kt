package com.agobikk.cookeatenjoy.ui.screens.recipe

import androidx.recyclerview.widget.DiffUtil
import com.agobikk.cookeatenjoy.model.RecipeList

class RecipeDiffUtil : DiffUtil.ItemCallback<RecipeList>() {
    override fun areItemsTheSame(oldItem: RecipeList, newItem: RecipeList) = oldItem === newItem

    override fun areContentsTheSame(oldItem: RecipeList, newItem: RecipeList) = oldItem == newItem

}