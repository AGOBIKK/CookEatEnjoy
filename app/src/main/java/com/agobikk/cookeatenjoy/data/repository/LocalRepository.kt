package com.agobikk.cookeatenjoy.data.repository

import androidx.lifecycle.LiveData
import com.agobikk.cookeatenjoy.data.local.entities.Ingredients
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity

interface LocalRepository {
    val getFoodInfo: LiveData<List<FoodInformationEntity>>
    val getFavoriteFood:LiveData<List<FavoriteRecipeEntity>>
    suspend fun searchFoodById(searchId: Long): FoodInformationEntity
    suspend fun insertFoodInfo(foodInformationEntity: FoodInformationEntity)
    suspend fun getIngredients(searchId: Long): Ingredients
//    fun deleteFoodInformation(): Flow<List<FoodInformationEntity>>


    fun getFavoriteRecipe(): LiveData<List<FavoriteRecipeEntity>>


    suspend fun insertFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity)



    suspend fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity)


    suspend fun deleteAllFavoriteRecipe()

    suspend fun searchFavoriteRecipeById(searchId: Long): FavoriteRecipeEntity

}