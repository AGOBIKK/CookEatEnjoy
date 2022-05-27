package com.agobikk.cookeatenjoy.application.di

import android.content.Context
import com.agobikk.cookeatenjoy.application.App
import com.agobikk.cookeatenjoy.application.di.modules.*
import com.agobikk.cookeatenjoy.data.local.Database
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import com.agobikk.cookeatenjoy.data.repository.LocalRepository
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeFragment
import com.agobikk.cookeatenjoy.ui.screens.ingredient.IngredientListFragment
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipeListFragment
import dagger.BindsInstance
import dagger.Component


@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RoomModule::class,
        CommonUiModule::class,
        MyUiBuilderModule::class,
        AppCommonModule::class
    ]
)

@NetworkModuleScope
interface AppComponent {

    fun getNetworkApi(): ApiService
    fun provideDatabase(): Database
    fun provideRemoteRepository(): RemoteRepository
    fun provideLocalRepository(): LocalRepository

    fun inject(fragment: RecipeListFragment)
    fun inject(fragment: DetailRecipeFragment)
    fun inject(fragment: IngredientListFragment)
    fun inject(application: App)

    @Component.Builder
    interface AppCompBuilder {
        fun buildAppComp(): AppComponent
        fun appModule(appModule: AppModule): AppCompBuilder
        fun setRoomModule(roomModule: RoomModule): AppCompBuilder
    }
}