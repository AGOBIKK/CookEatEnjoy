package com.agobikk.cookeatenjoy.data.remote.api

import com.agobikk.cookeatenjoy.model.FoodInformation
import com.agobikk.cookeatenjoy.model.ModelMainCourse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("recipes/complexSearch?type=main course&number=100&apiKey=f78cce0f5c43408db48b637be428697a")
    suspend fun getFoodMainCourse(): Response<ModelMainCourse>

    @GET("/recipes/716429/information?includeNutrition=false&apiKey=f78cce0f5c43408db48b637be428697a")
    suspend fun getFoodInformation(): Response<FoodInformation>
}