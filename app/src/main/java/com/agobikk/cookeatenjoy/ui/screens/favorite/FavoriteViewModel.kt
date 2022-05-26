package com.agobikk.cookeatenjoy.ui.screens.favorite

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.agobikk.cookeatenjoy.application.di.AssistedSavedStateViewModelFactory
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class FavoriteViewModel @AssistedInject constructor(
    private val repository: RemoteRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<FavoriteViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): FavoriteViewModel
    }

    fun getFavoriteRecipe() {

    }
}