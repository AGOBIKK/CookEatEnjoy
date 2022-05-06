package com.agobikk.cookeatenjoy.ui.screens.recipe

import androidx.recyclerview.widget.DiffUtil
import com.agobikk.cookeatenjoy.model.RecipeList
import com.agobikk.cookeatenjoy.model.ResultMainCourse

class RecipeDiffUtil : DiffUtil.ItemCallback<ResultMainCourse>() {
    override fun areItemsTheSame(oldItem: ResultMainCourse, newItem: ResultMainCourse) = oldItem === newItem

    override fun areContentsTheSame(oldItem: ResultMainCourse, newItem: ResultMainCourse) = oldItem == newItem

}