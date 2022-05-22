package com.agobikk.cookeatenjoy.aplication.di

import com.agobikk.cookeatenjoy.aplication.di.modules.AppModule
import com.agobikk.cookeatenjoy.aplication.di.modules.CommonViewModelModule
import com.agobikk.cookeatenjoy.aplication.di.modules.StorageModule
import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeFragment
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipeListFragment
import com.agobikk.cookeatenjoy.MainActivity
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeFragment
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipeListFragment
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

