package com.agobikk.cookeatenjoy.data.repository

import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient

interface StorageRepository {
    fun getIngredientList(recipeId:Long):List<ExtendedIngredient>
    fun insertFoodInfo(foodInformationEntity: FoodInformationEntity)
}