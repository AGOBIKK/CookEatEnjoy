package com.agobikk.cookeatenjoy.data

import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.repository.LocalRepository
import javax.inject.Inject

class Repository @Inject constructor(
    remoteRepository: RemoteRepository,
    localRepository: LocalRepository
) {
    val remote = remoteRepository
    val local = localRepository
}