package com.agobikk.cookeatenjoy.ui.screens.ingredient

import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity

interface OnIngredientClickListener {
    fun onClick(extendedIngredient: ExtendedIngredientEntity)
}