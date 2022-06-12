package com.agobikk.cookeatenjoy.application.di.modules

import android.app.Application
import android.content.Context
import com.agobikk.cookeatenjoy.data.repository.Repository
import com.agobikk.cookeatenjoy.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
object AppCommonModule {
    @Provides
    fun provideAppContext(application: Application): Context = application.applicationContext

}
