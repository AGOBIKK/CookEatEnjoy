package com.agobikk.cookeatenjoy.data.converters

import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.FoodInformation

interface ConvertFoodInformationEntity {
    fun convertFoodInformationEntity(value: FoodInformation, ingredient:List<ExtendedIngredientEntity>): FoodInformationEntity
}