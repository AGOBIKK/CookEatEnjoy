package com.agobikk.cookeatenjoy.aplication.di

import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.remote.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {
    @Suppress("FunctionName")
    @Binds
    fun bindRemoteRepositoryImpl_to_RemoteRepository(
        remoteRepositoryImpl: RemoteRepositoryImpl
    ): RemoteRepository
}