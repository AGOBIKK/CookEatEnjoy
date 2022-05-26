package com.agobikk.cookeatenjoy.aplication.di.modules

import androidx.lifecycle.ViewModel
import com.agobikk.cookeatenjoy.aplication.di.AssistedSavedStateViewModelFactory
import com.agobikk.cookeatenjoy.aplication.di.ViewModelKey
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeViewModel
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MyUiBuilderModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailRecipeViewModel::class)
    abstract fun bindsDetailRecipeViewModel(f: DetailRecipeViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

    @Binds
    @IntoMap
    @ViewModelKey(RecipesViewModel::class)
    abstract fun bindsRecipesViewModel(f: RecipesViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>
}
