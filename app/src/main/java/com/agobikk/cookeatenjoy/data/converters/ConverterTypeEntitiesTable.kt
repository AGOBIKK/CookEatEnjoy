package com.agobikk.cookeatenjoy.data.converters

import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import com.agobikk.cookeatenjoy.models.FoodInformation

interface ConverterTypeEntitiesTable {
    fun convertExtendedIngredient(value: ExtendedIngredient): ExtendedIngredientEntity
    fun convertFoodInformationEntity(value: FoodInformation,ingredient:List<ExtendedIngredientEntity>): FoodInformationEntity
}


class ImplTypeEntitiesTable : ConverterTypeEntitiesTable {
    override fun convertExtendedIngredient(value: ExtendedIngredient ): ExtendedIngredientEntity {
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

    override fun convertFoodInformationEntity(value: FoodInformation,ingredient:List<ExtendedIngredientEntity>): FoodInformationEntity {
        return FoodInformationEntity(
            id = value.id,
            image = value.image,
            instructions = value.instructions,
            title = value.title,
            sourceName = value.sourceName,
            extendedIngredientEntity = ingredient
        )
    }

}