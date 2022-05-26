package com.agobikk.cookeatenjoy.aplication.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.remote.RemoteRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
object AppCommonModule {
    @Provides
    fun provideAppContext(application: Application): Context = application.applicationContext
    @Provides
    fun provideRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl) :RemoteRepository =
        remoteRepositoryImpl
}
