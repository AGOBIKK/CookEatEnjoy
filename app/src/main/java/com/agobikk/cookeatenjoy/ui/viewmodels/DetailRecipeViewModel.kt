package com.agobikk.cookeatenjoy.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agobikk.cookeatenjoy.model.DetailRecipe
import com.agobikk.cookeatenjoy.model.RecipeList

class DetailRecipeViewModel : ViewModel() {


    private val _recipeDetail = MutableLiveData<List<DetailRecipe>?>()
    val recipeDetail: LiveData<List<DetailRecipe>?> = _recipeDetail


}