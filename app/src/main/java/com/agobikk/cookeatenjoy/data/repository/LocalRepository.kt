package com.agobikk.cookeatenjoy.data.repository

import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.data.local.entities.Ingredients
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun getFoodInfo(): List<FoodInformationEntity>
    val getFavoriteFood:Flow<List<FavoriteRecipeEntity>>
    suspend fun searchFoodById(searchId: Long): FoodInformationEntity
    suspend fun insertFoodInfo(foodInformationEntity: FoodInformationEntity)
    suspend fun getIngredients(searchId: Long): Ingredients
    suspend fun insertFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity)
    suspend fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity)
    suspend fun deleteAllFavoriteRecipe()
    suspend fun searchFavoriteRecipeById(searchId: Long): FavoriteRecipeEntity

}