package com.agobikk.cookeatenjoy.application.di.modules

import android.content.Context
import androidx.room.Room
import com.agobikk.cookeatenjoy.data.local.Database
import com.agobikk.cookeatenjoy.data.local.RoomConstants
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private val context: Context) {
    companion object {
        @Volatile
        private var INSTANCE: Database? = null

    }


    @Provides
    fun provideDatabase(): Database =
        INSTANCE ?: synchronized(this) {
            INSTANCE
                ?: buildDatabase().also { INSTANCE = it }
        }

    private fun buildDatabase() =
        Room.databaseBuilder(
            context.applicationContext,
            Database::class.java,
            RoomConstants.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideDao(database: Database): FoodInformationDao =
        database.getFoodInformation()
}
