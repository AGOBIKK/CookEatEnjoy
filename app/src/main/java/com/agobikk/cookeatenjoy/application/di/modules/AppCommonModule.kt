package com.agobikk.cookeatenjoy.application.di.modules

import android.app.Application
import android.content.Context
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.remote.RemoteRepositoryImpl
import com.agobikk.cookeatenjoy.data.repository.LocalRepository
import com.agobikk.cookeatenjoy.data.repository.LocalRepositoryImpl
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
