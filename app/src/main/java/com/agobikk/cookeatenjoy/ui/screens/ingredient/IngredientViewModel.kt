package com.agobikk.cookeatenjoy.ui.screens.ingredient

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.model.ExtendedIngredient
import kotlinx.coroutines.launch
import retrofit2.Response

class IngredientViewModel : ViewModel() {
    private val repository = RemoteRepository()


}