package com.agobikk.cookeatenjoy.data.remote

import com.agobikk.cookeatenjoy.models.FoodInformation
import com.agobikk.cookeatenjoy.models.ModelMainCourse
import retrofit2.Response

interface RemoteRepository {
    suspend fun getModelMainCourse(typeOfDish: String): Response<ModelMainCourse>

    suspend fun getFoodInformation(id: Long): Response<FoodInformation>
}