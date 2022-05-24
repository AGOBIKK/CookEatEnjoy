package com.agobikk.cookeatenjoy.data.repository

import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import com.agobikk.cookeatenjoy.models.FoodInformation

class StorageRepositoryImpl : StorageRepository{
    private var foodInformationRepo: List<FoodInformation> = emptyList()

    override fun getIngredientList(recipeId:Long):List<ExtendedIngredient>{
      return foodInformationRepo.find { it.id == recipeId }?.extendedIngredient ?: emptyList()
    }

    override fun insertFoodInfo(foodInformationEntity: FoodInformationEntity) {
        TODO("нужно подумать над методом insert list")
    }
}