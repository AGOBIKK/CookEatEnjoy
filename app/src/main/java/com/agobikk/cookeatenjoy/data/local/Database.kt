package com.agobikk.cookeatenjoy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformation


@Database(
    entities = [
        FoodInformation::class
    ],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase(){
    abstract fun getFoodInformation(): FoodInformationDao


    companion object {
        @Volatile
        private var INSTANCE: com.agobikk.cookeatenjoy.data.local.Database? = null

        fun createDatabase(context: Context): com.agobikk.cookeatenjoy.data.local.Database =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                com.agobikk.cookeatenjoy.data.local.Database::class.java,
                RoomConstants.DATABASE_NAME
            ).build()
    }
}
