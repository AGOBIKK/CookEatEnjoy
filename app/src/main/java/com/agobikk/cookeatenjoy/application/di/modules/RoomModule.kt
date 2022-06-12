package com.agobikk.cookeatenjoy.application.di.modules

import android.content.Context
import androidx.room.Room
import com.agobikk.cookeatenjoy.data.local.Database
import com.agobikk.cookeatenjoy.data.local.RoomConstants
import com.agobikk.cookeatenjoy.data.local.dao.FavoriteRecipeDao
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao

import com.agobikk.cookeatenjoy.data.repository.Repository
import com.agobikk.cookeatenjoy.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RoomModule(private val context: Context) {
    companion object {
        @Volatile
        private var INSTANCE: Database? = null

    }



    @Provides
    @NetworkModuleScope
    fun provideLocalRepository(localRepositoryImpl: RepositoryImpl) : Repository =
        localRepositoryImpl

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
    @NetworkModuleScope
    fun provideDao(database: Database): FoodInformationDao =
        database.getFoodInformation()

    @Provides
    @NetworkModuleScope
    fun provideFavoriteRecipeDao(database: Database):FavoriteRecipeDao =
        database.getFavoriteRecipe()
}


