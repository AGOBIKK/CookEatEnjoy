package com.agobikk.cookeatenjoy.ui.screens.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.model.ModelMainCourse
import kotlinx.coroutines.launch
import retrofit2.Response


class RecipesViewModel() : ViewModel() {
    private val repository = RemoteRepository()

    private val _recipeList = MutableLiveData<Response<ModelMainCourse>?>()
    val recipeList: LiveData<Response<ModelMainCourse>?> = _recipeList




    private fun getModelMainCourse() {
        viewModelScope.launch {
            _recipeList.postValue(repository.getModelMainCourse())
        }
    }

    fun onViewCreated() {
         getModelMainCourse()

    }


}