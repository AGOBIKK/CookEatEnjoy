package com.agobikk.cookeatenjoy.data.local.dao

import androidx.room.*
import com.agobikk.cookeatenjoy.data.local.RoomConstants.FOOD_INFO_TABLE
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.data.local.entities.Ingredients
import kotlinx.coroutines.flow.Flow


@Dao
interface FoodInformationDao {

    @Query("SELECT * FROM $FOOD_INFO_TABLE")
    suspend fun getFoodInfo(): List<FoodInformationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodInfo(foodInformationEntity: FoodInformationEntity)

    @Query("SELECT extended_ingredients FROM $FOOD_INFO_TABLE WHERE id_food LIKE :searchId")
    suspend fun getIngredients(searchId: Long): Ingredients

    @Delete
    suspend fun deleteFoodInformation(foodInformationEntity: List<FoodInformationEntity>)

    @Query("DELETE FROM $FOOD_INFO_TABLE")
    suspend fun deleteAllFoodInformation()

    @Query("SELECT * FROM $FOOD_INFO_TABLE WHERE id_food LIKE :searchId ")
    suspend fun searchFoodById(searchId: Long): FoodInformationEntity

}
