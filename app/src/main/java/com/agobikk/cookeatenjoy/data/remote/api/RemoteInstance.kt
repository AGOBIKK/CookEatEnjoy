package com.agobikk.cookeatenjoy.data.remote.api

import com.agobikk.cookeatenjoy.data.remote.NetworkConstants.BASE_URL
import com.agobikk.cookeatenjoy.data.remote.setClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .setClient()
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}