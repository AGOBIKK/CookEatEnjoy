package com.agobikk.cookeatenjoy.ui.screens.favorite

import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity


interface OnFavoriteClickListener {
    fun onClick(favoriteRecipeEntity: FavoriteRecipeEntity)
}