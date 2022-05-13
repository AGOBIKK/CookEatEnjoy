package com.agobikk.cookeatenjoy.data.local.dao

import androidx.room.*
import com.agobikk.cookeatenjoy.data.local.RoomConstants.FOOD_INFO_TABLE
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformation


@Dao
interface FoodInformationDao {
    @Query("SELECT * FROM $FOOD_INFO_TABLE")
    fun getFoodInfo(): FoodInformation

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFoodInfo(foodInformation: FoodInformation)

    @Delete
    suspend fun deleteFoodInformation(foodInformation: List<FoodInformation>)

    @Query("DELETE FROM $FOOD_INFO_TABLE")
    suspend fun deleteAllFoodInformation()

}