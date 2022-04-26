package com.agobikk.cookeatenjoy.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.agobikk.cookeatenjoy.model.RecipeList

class  RecipeDiffUtil : DiffUtil.ItemCallback<RecipeList>() {
    override fun areItemsTheSame(oldItem: RecipeList, newItem: RecipeList): Boolean {
        return oldItem === newItem
    }
    override fun areContentsTheSame(oldItem: RecipeList, newItem: RecipeList): Boolean {
        return oldItem == newItem
    }
}