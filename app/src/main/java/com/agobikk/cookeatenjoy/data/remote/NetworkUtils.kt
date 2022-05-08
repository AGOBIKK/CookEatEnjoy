package com.agobikk.cookeatenjoy.data.remote

import com.agobikk.cookeatenjoy.BuildConfig
import com.agobikk.cookeatenjoy.data.remote.NetworkConstants.API_KEY_HEADER
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

fun Retrofit.Builder.setClient() = apply {
    val okHttpClient = OkHttpClient.Builder()
        .addHeaderInterceptor()
        .addHttpLoggingInterceptor()
        .build()

    this.client(okHttpClient)
}
private fun OkHttpClient.Builder.addHeaderInterceptor() = apply {
    val interceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .addHeader(API_KEY_HEADER, BuildConfig.API_KEY)
            .build()

        chain.proceed(request)
    }
    this.addInterceptor(interceptor)
}

private fun OkHttpClient.Builder.addHttpLoggingInterceptor() = apply {
    if (BuildConfig.DEBUG) {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        this.addNetworkInterceptor(interceptor)
    }
}