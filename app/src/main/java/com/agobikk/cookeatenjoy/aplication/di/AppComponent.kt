package com.agobikk.cookeatenjoy.aplication.di

import dagger.Component
import javax.inject.Singleton

@NetworkModuleScope
@Component(
    modules = [
        AppModule::class,
        StorageModule::class,
        NetworkModule::class,
        AppBindModule::class,
        ViewModelModule::class
    ]
)
@Singleton
interface AppComponent {

    fun getViewModelFactory(): ViewModelFactory


    @Component.Builder
    interface AppCompBuilder {
        fun buildAppComp(): AppComponent
        fun appModule(appModule: AppModule): AppCompBuilder
    }
}

