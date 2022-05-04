package com.agobikk.cookeatenjoy.ui.screens.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agobikk.cookeatenjoy.model.RecipeList


class RecipesViewModel() : ViewModel() {


    private val _recipeList = MutableLiveData<List<RecipeList>?>()
    val recipeList: LiveData<List<RecipeList>?> = _recipeList

}