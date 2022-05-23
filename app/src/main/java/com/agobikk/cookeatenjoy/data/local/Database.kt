package com.agobikk.cookeatenjoy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity


@Database(
    entities = [
        FoodInformationEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(RoomConverters::class)
abstract class Database : RoomDatabase(){
    abstract fun getFoodInformation(): FoodInformationDao
}
