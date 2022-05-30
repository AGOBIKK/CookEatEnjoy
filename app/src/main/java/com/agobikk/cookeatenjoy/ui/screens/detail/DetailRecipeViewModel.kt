package com.agobikk.cookeatenjoy.ui.screens.detail

import androidx.lifecycle.*
import com.agobikk.cookeatenjoy.application.di.AssistedSavedStateViewModelFactory
import com.agobikk.cookeatenjoy.data.Repository
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.FoodInformation
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.Response
import timber.log.Timber

class DetailRecipeViewModel @AssistedInject constructor(
    private val repository: Repository,
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

//    val myFlow: Flow<FoodInformationEntity> = flow {
//        val body = recipeDetail.value?.body() ?:  FoodInformation(1,"","","","", emptyList())
//        val converter = ImplTypeEntitiesTable()
//        val ingredients =
//            body.extendedIngredient.map { converter.convertExtendedIngredient(it) } ?: emptyList()
//        val foodInformation = converter.convertFoodInformationEntity(body,ingredients)
//        emit(foodInformation)
//    }.flowOn(Dispatchers.Default)



    private fun getFoodInformation(id: Long) {
        viewModelScope.launch {
            _recipeDetail.postValue(repository.remote.getFoodInformation(id = id))
        }
    }

    fun onViewCreated(id: Long) {
        getFoodInformation(id = id)
    }




    fun insert(foodInformationEntity: FoodInformationEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertFoodInfo(foodInformationEntity)
        }


    fun insertFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertFavoriteRecipe(favoriteRecipeEntity)
        }

    fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.deleteFavoriteRecipe(favoriteRecipeEntity)
        }


//    val foodInformationLiveData: Flow<List<FoodInformationEntity>> = repository.local.getFoodInfo.asFlow()


//    fun delete(foodInformationEntity: List<FoodInformationEntity>) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.local.deleteFoodInformation(foodInformationEntity)
//        }
//    }

//    val readRecipes: LiveData<List<RecipesEntity>> = repository.local.readRecipes().asLiveData()
}
