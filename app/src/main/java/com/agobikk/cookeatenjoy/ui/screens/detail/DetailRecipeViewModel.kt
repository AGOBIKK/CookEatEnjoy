package com.agobikk.cookeatenjoy.ui.screens.detail

import androidx.lifecycle.*
import com.agobikk.cookeatenjoy.application.di.AssistedSavedStateViewModelFactory
import com.agobikk.cookeatenjoy.data.repository.Repository
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class DetailRecipeViewModel @AssistedInject constructor(
    private val repository: Repository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<DetailRecipeViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): DetailRecipeViewModel
    }

    private val _recipeDetail = MutableLiveData<FoodInformationEntity?>()
    val recipeDetail: LiveData<FoodInformationEntity?> = _recipeDetail


    private fun getFoodInformation(id: Long) {
        viewModelScope.launch {
            _recipeDetail.postValue(repository.getFoodInfo(id))
        }
    }

    fun onViewCreated(id: Long) {
        getFoodInformation(id = id)
    }

    fun insert(foodInformationEntity: FoodInformationEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertFoodInfo(foodInformationEntity)
        }

    fun insertFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertFavoriteRecipe(favoriteRecipeEntity)
        }

    fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFavoriteRecipe(favoriteRecipeEntity)
        }
}
