package com.agobikk.cookeatenjoy.data.converters

import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient

interface –°onvertExtendedIngredient {
    fun convertExtendedIngredient(value: ExtendedIngredient): ExtendedIngredientEntity
}