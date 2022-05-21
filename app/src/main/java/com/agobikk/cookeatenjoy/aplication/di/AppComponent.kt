package com.agobikk.cookeatenjoy.aplication.di

import com.agobikk.cookeatenjoy.MainActivity
import com.agobikk.cookeatenjoy.data.remote.RemoteRepositoryImpl
import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import dagger.Component
import dagger.Provides

@Component(
    modules = [
        AppModule::class,
        StorageModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun injectMainActivity(activity: MainActivity)
    fun getApi(): NetworkModule


    @Component.Builder
    interface AppCompBuilder {
        fun buildAppComp(): AppComponent
        fun appModule(appModule: AppModule): AppCompBuilder
    }
}