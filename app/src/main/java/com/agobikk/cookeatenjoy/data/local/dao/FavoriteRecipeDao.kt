package com.agobikk.cookeatenjoy.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.agobikk.cookeatenjoy.data.local.RoomConstants
import com.agobikk.cookeatenjoy.data.local.RoomConstants.FAVORITE_RECIPES_TABLE
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity

@Dao
interface FavoriteRecipeDao {

        @Query("SELECT * FROM $FAVORITE_RECIPES_TABLE")
        fun getFavoriteRecipe(): LiveData<List<FavoriteRecipeEntity>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity)


        @Delete
        suspend fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity)

        @Query("DELETE FROM $FAVORITE_RECIPES_TABLE")
        suspend fun deleteAllFoodInformation()

        @Query("SELECT * FROM $FAVORITE_RECIPES_TABLE WHERE id_food LIKE :searchId ")
        suspend fun searchFavoriteRecipeById(searchId: Long): FavoriteRecipeEntity

    }

