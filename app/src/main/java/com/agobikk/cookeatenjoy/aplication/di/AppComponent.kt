package com.agobikk.cookeatenjoy.aplication.di

import com.agobikk.cookeatenjoy.MainActivity
import com.agobikk.cookeatenjoy.data.remote.api.RemoteInstance
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        StorageModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun injectMainActivity(activity: MainActivity)
//    fun injectObject(remoteInstance: RemoteInstance)

    @Component.Builder
    interface AppCompBuilder {
        fun buildAppComp(): AppComponent
        fun appModule(appModule: AppModule): AppCompBuilder

    }
}