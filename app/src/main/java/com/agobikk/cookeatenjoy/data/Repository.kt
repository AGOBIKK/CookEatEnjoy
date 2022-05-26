package com.agobikk.cookeatenjoy.data

import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.remote.RemoteRepositoryImpl
import com.agobikk.cookeatenjoy.data.repository.LocalRepository
import com.agobikk.cookeatenjoy.data.repository.LocalRepositoryImpl
import javax.inject.Inject

class Repository @Inject constructor(
    remoteRepository: RemoteRepositoryImpl,
    localRepository: LocalRepositoryImpl
) {
    val remote = remoteRepository
    val local = localRepository
}