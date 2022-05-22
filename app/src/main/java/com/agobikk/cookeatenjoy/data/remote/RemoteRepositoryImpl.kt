package com.agobikk.cookeatenjoy.data.remote

import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import com.agobikk.cookeatenjoy.model.FoodInformation
import com.agobikk.cookeatenjoy.model.ModelMainCourse
import retrofit2.Response
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private var networkModule: ApiService
) :
    RemoteRepository {


    override suspend fun getModelMainCourse(typeOfDish: String): Response<ModelMainCourse> {
        return networkModule.getFoodMainCourse(typeOfDish = typeOfDish)

    }

    override suspend fun getFoodInformation(id: Long): Response<FoodInformation> {
        return networkModule.getFoodInformation(id)
    }

}