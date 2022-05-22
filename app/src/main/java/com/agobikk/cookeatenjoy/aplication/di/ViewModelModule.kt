package com.agobikk.cookeatenjoy.aplication.di

import androidx.lifecycle.ViewModel
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeViewModel
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipesViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
class ViewModelModule {

    @IntoMap
    @ViewModelKey(RecipesViewModel::class)
    @Provides
    fun provideRecipesViewModel(repository: RemoteRepository): ViewModel {
        return provideRecipesViewModel(repository)
    }

    @IntoMap
    @ViewModelKey(DetailRecipeViewModel::class)
    @Provides
    fun provideDetailRecipeViewModel(repository: RemoteRepository): ViewModel {
        return DetailRecipeViewModel(repository)
    }

    @MapKey
    @Retention(AnnotationRetention.RUNTIME)
    annotation class ViewModelKey(val value: KClass<out ViewModel>)
}