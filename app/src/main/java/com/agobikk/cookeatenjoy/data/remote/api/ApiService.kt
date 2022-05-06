package com.agobikk.cookeatenjoy.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("recipes/complexSearch?type=main course&apiKey=33a0b45be3c547c9a7c1578ef602e6b2")
    suspend fun getFoodMainCourse(): Response<ModelMainCourse>

}