package com.agobikk.cookeatenjoy.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.ui.screens.detail.DetailRecipeViewModel
import com.agobikk.cookeatenjoy.ui.screens.recipe.RecipesViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val repository: RemoteRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            RecipesViewModel::class -> RecipesViewModel(repository)
            DetailRecipeViewModel::class -> DetailRecipeViewModel(repository)
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        } as T
    }


}