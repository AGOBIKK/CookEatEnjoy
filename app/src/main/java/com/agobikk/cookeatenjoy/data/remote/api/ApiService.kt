package com.agobikk.cookeatenjoy.data.remote.api

import com.agobikk.cookeatenjoy.model.FoodInformation
import com.agobikk.cookeatenjoy.model.ModelMainCourse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("recipes/complexSearch?")
    suspend fun getFoodMainCourse(
        @Query("type") typeOfDish: String,
        @Query("number") number: Int = 100
    ): Response<ModelMainCourse>

    @GET("/recipes/{id}/information?includeNutrition=false")
    suspend fun getFoodInformation(@Path("id") id: Int): Response<FoodInformation>
}