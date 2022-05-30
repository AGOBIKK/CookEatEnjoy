package com.agobikk.cookeatenjoy.ui.screens.favorite

import androidx.recyclerview.widget.DiffUtil
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ResultMainCourse

class FavoriteDiffUtil : DiffUtil.ItemCallback<FavoriteRecipeEntity>() {
    override fun areItemsTheSame(oldItem: FavoriteRecipeEntity, newItem: FavoriteRecipeEntity) =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: FavoriteRecipeEntity, newItem: FavoriteRecipeEntity) =
        oldItem == newItem

}