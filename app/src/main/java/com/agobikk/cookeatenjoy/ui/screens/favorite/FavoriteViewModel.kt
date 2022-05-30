package com.agobikk.cookeatenjoy.ui.screens.favorite

import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.agobikk.cookeatenjoy.application.di.AssistedSavedStateViewModelFactory
import com.agobikk.cookeatenjoy.data.Repository
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class FavoriteViewModel @AssistedInject constructor(
    private val repository: Repository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<FavoriteViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): FavoriteViewModel
    }

   fun getAllRecipe(): LiveData<List<FavoriteRecipeEntity>> {
        return repository.local.getFavoriteFood
    }

}

