package com.agobikk.cookeatenjoy.aplication.di

import androidx.lifecycle.ViewModel
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeViewModel
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipesViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
class ViewModelModule {
    @IntoMap
    @ViewModelKey (RecipesViewModel::class)
    @Provides
    fun provideRecipesViewModel(remoteRepository: RemoteRepository): ViewModel {
        return RecipesViewModel(remoteRepository)
    }

    @IntoMap
    @ViewModelKey(DetailRecipeViewModel::class)
    @Provides
    fun provideDetailRecipeViewModel(remoteRepository: RemoteRepository): ViewModel {
        return DetailRecipeViewModel(remoteRepository)
    }
}