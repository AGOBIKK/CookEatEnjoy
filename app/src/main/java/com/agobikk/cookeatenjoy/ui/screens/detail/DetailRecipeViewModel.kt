package com.agobikk.cookeatenjoy.ui.screens.detail

import androidx.lifecycle.*
import com.agobikk.cookeatenjoy.application.di.AssistedSavedStateViewModelFactory
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.models.FoodInformation
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import retrofit2.Response
import timber.log.Timber

class DetailRecipeViewModel @AssistedInject constructor (
    private  val repository: RemoteRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
    ) : ViewModel() {

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<DetailRecipeViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): DetailRecipeViewModel
    }
    val someValue = savedStateHandle.getLiveData("detail", 45647464)

    init {
        Timber.d("-------------some.value:${someValue.value}")
        Timber.d("-------------some.value:${savedStateHandle.get<Long>("detail_some")}")

    }

    private val _recipeDetail = MutableLiveData<Response<FoodInformation>?>()
    val recipeDetail: LiveData<Response<FoodInformation>?> = _recipeDetail

    private fun getFoodInformation(id: Long) {
        viewModelScope.launch {
            _recipeDetail.postValue(repository.getFoodInformation(id = id))
        }
    }

    fun onViewCreated(id: Long) {
        getFoodInformation(id = id)
    }
}