package com.agobikk.cookeatenjoy.aplication.di

import com.agobikk.cookeatenjoy.ui.screens.ViewModelFactory
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        StorageModule::class,
        NetworkModule::class,
        AppBindModule::class
    ]
)
interface AppComponent {


    @Component.Builder
    interface AppCompBuilder {
        fun buildAppComp(): AppComponent
        fun appModule(appModule: AppModule): AppCompBuilder
    }
}

