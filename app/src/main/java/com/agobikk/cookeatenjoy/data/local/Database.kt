package com.agobikk.cookeatenjoy.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.agobikk.cookeatenjoy.data.local.dao.FavoriteRecipeDao
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity


@Database(
    entities = [
        FoodInformationEntity::class,
        FavoriteRecipeEntity::class
    ],
    version = 2,
    exportSchema = true,
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ]
)
@TypeConverters(RoomConverters::class)
abstract class Database : RoomDatabase() {
    abstract fun getFoodInformation(): FoodInformationDao
    abstract fun getFavoriteRecipe(): FavoriteRecipeDao
}
