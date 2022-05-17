package com.agobikk.cookeatenjoy.ui.screens.ingredient

import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.model.ExtendedIngredient

interface OnIngredientClickListener {
    fun onClick(extendedIngredient: ExtendedIngredientEntity)
}