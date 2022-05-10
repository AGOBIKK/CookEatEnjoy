package com.agobikk.cookeatenjoy.data.remote.api

import com.agobikk.cookeatenjoy.model.FoodInformation
import com.agobikk.cookeatenjoy.model.ModelMainCourse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("recipes/complexSearch?type=main course&number=100")
    suspend fun getFoodMainCourse(): Response<ModelMainCourse>

    @GET("/recipes/{id}/information?includeNutrition=false")
    suspend fun getFoodInformation(@Path("id") id: Int): Response<FoodInformation>
}