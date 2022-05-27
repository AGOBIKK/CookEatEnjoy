package com.agobikk.cookeatenjoy.data.repository

import androidx.lifecycle.LiveData
import com.agobikk.cookeatenjoy.data.local.dao.Ingredients
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient

interface LocalRepository {
    suspend fun  getFoodInfo(): LiveData<List<FoodInformationEntity>>
    suspend fun searchFoodById(searchId: Long): FoodInformationEntity
    suspend fun insertFoodInfo(foodInformationEntity: FoodInformationEntity)
    suspend fun getIngredients(searchId: Long): Ingredients
    suspend fun deleteFoodInformation(foodInformationEntity: List<FoodInformationEntity>)
}