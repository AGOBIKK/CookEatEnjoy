package com.agobikk.cookeatenjoy.aplication.di

import com.agobikk.cookeatenjoy.aplication.di.modules.*
import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeFragment
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipeListFragment
import dagger.Component


@Component(
    modules = [
        AppModule::class,
        StorageModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        CommonViewModelModule::class
    ]
)

@NetworkModuleScope
interface AppComponent {

    fun getNetworkApi(): ApiService



    fun inject(fragment: RecipeListFragment)
    fun inject(fragment: DetailRecipeFragment)

    @Component.Builder
    interface AppCompBuilder {
        fun buildAppComp(): AppComponent
        fun appModule(appModule: AppModule): AppCompBuilder
    }
}