package com.agobikk.cookeatenjoy.application.di.modules

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.agobikk.cookeatenjoy.data.local.Database
import com.agobikk.cookeatenjoy.data.local.RoomConstants
import com.agobikk.cookeatenjoy.data.local.dao.FavoriteRecipeDao
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.data.repository.LocalRepository
import com.agobikk.cookeatenjoy.data.repository.LocalRepositoryImpl
import dagger.MapKey
import dagger.Module
import dagger.Provides
import javax.inject.Scope
import javax.inject.Singleton
import kotlin.reflect.KClass

@Module
class RoomModule(private val context: Context) {
    companion object {
        @Volatile
        private var INSTANCE: Database? = null

    }



    @Provides
    @NetworkModuleScope
    fun provideLocalRepository(localRepositoryImpl: LocalRepositoryImpl) : LocalRepository =
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


