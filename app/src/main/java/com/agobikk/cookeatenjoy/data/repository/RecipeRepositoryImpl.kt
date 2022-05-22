package com.agobikk.cookeatenjoy.data.repository

import com.agobikk.cookeatenjoy.model.ExtendedIngredient
import com.agobikk.cookeatenjoy.model.FoodInformation

class RecipeRepositoryImpl {
    private var foodInformationRepo: List<FoodInformation> = emptyList()

    fun getIngredientList(recipeId:Long):List<ExtendedIngredient>{
      return foodInformationRepo.find { it.id == recipeId }?.extendedIngredient ?: emptyList()
    }
}