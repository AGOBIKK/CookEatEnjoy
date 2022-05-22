package com.agobikk.cookeatenjoy.data.remote

import com.agobikk.cookeatenjoy.model.FoodInformation
import com.agobikk.cookeatenjoy.model.ModelMainCourse
import retrofit2.Response

interface RemoteRepository {
    suspend fun getModelMainCourse(typeOfDish: String): Response<ModelMainCourse>

    suspend fun getFoodInformation(id: Long): Response<FoodInformation>
}