package com.agobikk.cookeatenjoy.ui.screens.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.model.RecipeList
import com.agobikk.cookeatenjoy.model.ResultMainCourse
import kotlinx.coroutines.launch


class RecipesViewModel() : ViewModel() {
    private val repository = RemoteRepository()

    private val _recipeList = MutableLiveData<List<ResultMainCourse>?>()
    val recipeList: LiveData<List<ResultMainCourse>?> = _recipeList


    fun getMovies() {
        viewModelScope.launch {
            _recipeList.value = repository
        }
}