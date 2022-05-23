package com.agobikk.cookeatenjoy.ui.screens.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.models.ModelMainCourse
import kotlinx.coroutines.launch
import retrofit2.Response


class RecipesViewModel(private val repository: RemoteRepository) : ViewModel() {


    private val _recipeList = MutableLiveData<Response<ModelMainCourse>?>()
    val recipeList: LiveData<Response<ModelMainCourse>?> = _recipeList


    private fun getModelMainCourse(typeOfDish: String) {
        viewModelScope.launch {
            _recipeList.postValue(repository.getModelMainCourse(typeOfDish = typeOfDish))
        }
    }

    fun onViewCreated(typeOfDish: String) {
        getModelMainCourse(typeOfDish)

    }


}