package com.agobikk.cookeatenjoy.data.converters

import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.FoodInformation

class ConvertFoodInformationEntityImpl :ConvertFoodInformationEntity{
    override fun convertFoodInformationEntity(value: FoodInformation, ingredient:List<ExtendedIngredientEntity>): FoodInformationEntity {
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