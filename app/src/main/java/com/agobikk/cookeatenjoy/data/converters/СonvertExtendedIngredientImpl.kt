package com.agobikk.cookeatenjoy.data.converters

import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient

class СonvertExtendedIngredientImpl:СonvertExtendedIngredient {
    override fun convertExtendedIngredient(value: ExtendedIngredient): ExtendedIngredientEntity {
        return ExtendedIngredientEntity(
            idExtendedIngredient = value.idExtendedIngredient,
            amount = value.amount,
            consistency = value.consistency,
            image_ingredient = value.image,
            name = value.name,
            original = value.original,
            unit = value.unit
        )
    }
}