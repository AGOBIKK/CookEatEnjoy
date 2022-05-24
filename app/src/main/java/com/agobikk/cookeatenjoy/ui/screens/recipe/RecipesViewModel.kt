package com.agobikk.cookeatenjoy.ui.screens.recipe


import androidx.lifecycle.*
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.models.ModelMainCourse
import com.agobikk.cookeatenjoy.ui.screens.category.ChooseCategoryDish
import kotlinx.coroutines.launch
import retrofit2.Response


class RecipesViewModel(private val repository: RemoteRepository, ) : ViewModel(){


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