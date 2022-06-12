package com.agobikk.cookeatenjoy.data.repository

import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.converters.СonverterExtendedIngredientImpl
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.data.local.entities.Ingredients
import com.agobikk.cookeatenjoy.models.FoodInformation
import com.agobikk.cookeatenjoy.models.ModelMainCourse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {
    suspend fun readFoodInformationFromServer(id: Long): FoodInformationEntity

    suspend fun saveToDataBase(foodInformationEntity: FoodInformationEntity)

    suspend fun getFoodInfo(id: Long): FoodInformationEntity
    suspend fun getFoodInfo(): List<FoodInformationEntity>
    val getFavoriteFood: Flow<List<FavoriteRecipeEntity>>
    suspend fun searchFoodById(searchId: Long): FoodInformationEntity
    suspend fun insertFoodInfo(foodInformationEntity: FoodInformationEntity)
    suspend fun getIngredients(searchId: Long): Ingredients
    suspend fun insertFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity)
    suspend fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity)
    suspend fun deleteAllFavoriteRecipe()
    suspend fun searchFavoriteRecipeById(searchId: Long): FavoriteRecipeEntity
    suspend fun getModelMainCourse(typeOfDish: String): Response<ModelMainCourse>

    suspend fun getFoodInformation(id: Long): Response<FoodInformation>
}