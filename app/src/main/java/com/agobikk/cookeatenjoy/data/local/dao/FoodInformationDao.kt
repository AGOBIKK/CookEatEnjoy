package com.agobikk.cookeatenjoy.data.local.dao

import androidx.room.*
import com.agobikk.cookeatenjoy.data.local.RoomConstants.FOOD_INFO_TABLE
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformation


@Dao
interface FoodInformationDao {
    @Query("SELECT * FROM $FOOD_INFO_TABLE")
    suspend fun getFoodInfo(): List<FoodInformation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodInfo(foodInformation: FoodInformation)

   @Query("SELECT extended_ingredients FROM $FOOD_INFO_TABLE WHERE id_food LIKE :searchId")
    suspend fun getIngredients(searchId: Long):Ingredients

    @Delete
    suspend fun deleteFoodInformation(foodInformation: List<FoodInformation>)

    @Query("DELETE FROM $FOOD_INFO_TABLE")
    suspend fun deleteAllFoodInformation()

    @Query("SELECT * FROM $FOOD_INFO_TABLE WHERE id_food LIKE :searchId ")
    suspend fun searchFoodById(searchId: Long): FoodInformation

}

data class Ingredients(
    @ColumnInfo(name = "extended_ingredients") var extendedIngredientEntity: List<ExtendedIngredientEntity>
)