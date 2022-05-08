package com.agobikk.cookeatenjoy.data.remote.api

import com.agobikk.cookeatenjoy.model.FoodInformation
import com.agobikk.cookeatenjoy.model.ModelMainCourse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("recipes/complexSearch?type=main course&number=100")
    suspend fun getFoodMainCourse(): Response<ModelMainCourse>

    @GET("/recipes/716429/information?includeNutrition=false")
    suspend fun getFoodInformation(): Response<FoodInformation>
}