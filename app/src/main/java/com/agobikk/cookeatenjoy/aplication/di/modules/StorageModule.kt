package com.agobikk.cookeatenjoy.aplication.di.modules

import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.remote.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface StorageModule {
    @Binds
    fun bindRemoteRepositoryImpl_to_RemoteRepository(
        remoteRepositoryImpl: RemoteRepositoryImpl
    ): RemoteRepository
}

