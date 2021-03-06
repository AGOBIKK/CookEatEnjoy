package com.agobikk.cookeatenjoy.application.di

import android.content.Context
import com.agobikk.cookeatenjoy.application.App
import com.agobikk.cookeatenjoy.application.di.modules.*
import com.agobikk.cookeatenjoy.data.local.Database
import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import com.agobikk.cookeatenjoy.data.repository.Repository
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeFragment
import com.agobikk.cookeatenjoy.ui.screens.favorite.FavoriteFragment
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
    fun provideRepository(): Repository


    fun inject(fragment: RecipeListFragment)
    fun inject(fragment: DetailRecipeFragment)
    fun inject(fragment: IngredientListFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(application: App)


    @Component.Builder
    interface AppCompBuilder {

        fun buildAppComp(): AppComponent
        @BindsInstance
        fun context(context: Context): AppCompBuilder

        fun appModule(appModule: AppModule): AppCompBuilder
        fun setRoomModule(roomModule: RoomModule): AppCompBuilder
    }
}