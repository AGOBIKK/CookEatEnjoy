package com.agobikk.cookeatenjoy.data.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agobikk.cookeatenjoy.data.local.RoomConstants
import com.agobikk.cookeatenjoy.data.local.dao.Ingredients
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    val getFoodInfo: LiveData<List<FoodInformationEntity>>
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