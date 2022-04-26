package com.agobikk.cookeatenjoy.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agobikk.cookeatenjoy.model.RecipeList

class RecipesViewModel : ViewModel() {


    private val _recipeList =
        MutableLiveData<List<RecipeList>>() // изменяемая LiveData для внутреннего использования
    val recipeList: LiveData<List<RecipeList>> =
        _recipeList //  публичнмя переменная отдаём её Вью для внешнего использования(она не изменяемая LiveData)


    /*
Во вьюмодели мы должны описать операции которые разрешено делать из фрагмента
А так же даные которые вьюмодель будет отправлять во фрагмент
В нашем случае это загрузка рецептов,  и запуск экрана с деталями рецептов
*/


}