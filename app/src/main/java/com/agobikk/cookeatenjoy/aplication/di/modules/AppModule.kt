package com.agobikk.cookeatenjoy.aplication.di.modules

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {
    @Provides
    fun getPreferences(): SharedPreferences {
        return context.getSharedPreferences("prefs", MODE_PRIVATE)
    }

    @Provides
    fun getResources(): Resources {
        return context.resources
    }


}