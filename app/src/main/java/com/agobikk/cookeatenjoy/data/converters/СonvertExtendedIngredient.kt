package com.agobikk.cookeatenjoy.data.converters

import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient

interface СonvertExtendedIngredient {
    fun convertExtendedIngredient(value: ExtendedIngredient): ExtendedIngredientEntity
}