package com.agobikk.cookeatenjoy.ui.screens.recipe


import androidx.lifecycle.*
import com.agobikk.cookeatenjoy.application.di.AssistedSavedStateViewModelFactory
import com.agobikk.cookeatenjoy.data.repository.Repository
import com.agobikk.cookeatenjoy.models.ModelMainCourse
import com.agobikk.cookeatenjoy.ui.screens.category.ChooseCategoryDish
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import retrofit2.Response

class RecipesViewModel @AssistedInject constructor(
    private val repository: Repository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<RecipesViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): RecipesViewModel
    }

    private val _recipeList = MutableLiveData<Response<ModelMainCourse>?>()
    val recipeList: LiveData<Response<ModelMainCourse>?> = _recipeList

    private fun getModelMainCourse(typeOfDish: String) {
        viewModelScope.launch {
            _recipeList.postValue(repository.getModelMainCourse(typeOfDish = typeOfDish))
        }
    }

    fun onViewCreated() {
        getModelMainCourse(typeOfDish = ChooseCategoryDish.chooseDishOfType)
    }

    fun updateListRecipeInformation(
        viewLifecycleOwner: LifecycleOwner,
        adapter: RecipesAdapter
    ) {
        recipeList.observe(viewLifecycleOwner::getLifecycle) { list ->
            adapter.submitList(list?.body()?.results)
        }
    }
}