package com.agobikk.cookeatenjoy.data.local.dao

import androidx.room.ColumnInfo
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity

data class Ingredients(
    @ColumnInfo(name = "extended_ingredients") var extendedIngredientEntity: List<ExtendedIngredientEntity>
)
