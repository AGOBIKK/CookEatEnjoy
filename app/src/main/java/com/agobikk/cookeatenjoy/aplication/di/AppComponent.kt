package com.agobikk.cookeatenjoy.aplication.di

import com.agobikk.cookeatenjoy.aplication.di.modules.AppModule
import com.agobikk.cookeatenjoy.aplication.di.modules.CommonViewModelModule
import com.agobikk.cookeatenjoy.aplication.di.modules.StorageModule
import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeFragment
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipeListFragment
import dagger.Component

@NetworkModuleScope

@Component(
    modules = [
        AppModule::class,
        StorageModule::class,
        NetworkModule::class,
        AppBindModule::class,
        ViewModelModule::class
        ViewModelModule::class,
        CommonViewModelModule::class
    ]
)
interface AppComponent {

    fun getViewModelFactory(): ViewModelFactory

    fun getNetworkApi(): ApiService



    fun inject(fragment: RecipeListFragment)
    fun inject(fragment: DetailRecipeFragment)

    @Component.Builder
    interface AppCompBuilder {
        fun buildAppComp(): AppComponent
        fun appModule(appModule: AppModule): AppCompBuilder
    }
}

