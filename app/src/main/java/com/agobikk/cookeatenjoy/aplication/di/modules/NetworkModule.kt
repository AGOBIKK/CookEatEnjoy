package com.agobikk.cookeatenjoy.aplication.di


import com.agobikk.cookeatenjoy.BuildConfig
import com.agobikk.cookeatenjoy.data.remote.NetworkConstants
import com.agobikk.cookeatenjoy.data.remote.api.ApiService

import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {


    @Provides
    @NetworkModuleScope
    fun provideApi(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
     fun Retrofit.Builder.retrofit() = apply {
            Retrofit.Builder()
                .baseUrl(NetworkConstants.BASE_URL)
                .setClient()
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    @Provides
    @Singleton
    fun Retrofit.Builder.setClient() = apply {
        val okHttpClient = OkHttpClient.Builder()
            .addHeaderInterceptor()
            .addHttpLoggingInterceptor()
            .build()

        this.client(okHttpClient)
    }

    @Provides
    @Singleton
    fun OkHttpClient.Builder.addHeaderInterceptor() = apply {
        val interceptor = Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader(NetworkConstants.API_KEY_HEADER, BuildConfig.API_KEY)
                .build()

            chain.proceed(request)
        }
        this.addInterceptor(interceptor)
    }

    @Provides
    @Singleton
    fun OkHttpClient.Builder.addHttpLoggingInterceptor() = apply {
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            this.addNetworkInterceptor(interceptor)
        }
    }
}