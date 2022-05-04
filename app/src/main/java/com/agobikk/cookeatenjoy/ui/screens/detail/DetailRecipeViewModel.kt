package com.agobikk.cookeatenjoy.ui.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agobikk.cookeatenjoy.model.DetailRecipe
import com.agobikk.cookeatenjoy.model.RecipeList

class DetailRecipeViewModel : ViewModel() {


    private val _recipeDetail = MutableLiveData<DetailRecipe>()
    val recipeDetail: LiveData<DetailRecipe> = _recipeDetail

    private val _favorite = MutableLiveData<Boolean>()
    val favorite: LiveData<Boolean> = _favorite
}