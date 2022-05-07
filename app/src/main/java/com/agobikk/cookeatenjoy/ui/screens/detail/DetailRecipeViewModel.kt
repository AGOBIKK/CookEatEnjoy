package com.agobikk.cookeatenjoy.ui.screens.detail

import androidx.lifecycle.*
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.model.DetailRecipe
import com.agobikk.cookeatenjoy.model.FoodInformation
import com.agobikk.cookeatenjoy.model.RecipeList
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailRecipeViewModel : ViewModel() {
    private val repository = RemoteRepository()

    private val _recipeDetail = MutableLiveData < Response<FoodInformation>?>()
    val recipeDetail: LiveData< Response<FoodInformation>?> = _recipeDetail

    fun getFoodInformation() {
        viewModelScope.launch {
            _recipeDetail.value = repository.getFoodInformation()
        }
    }
   fun onViewCreated(){
       getFoodInformation()
   }

}