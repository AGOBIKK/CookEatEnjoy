package com.agobikk.cookeatenjoy.data.remote

import com.agobikk.cookeatenjoy.data.remote.api.RemoteInstance
import com.agobikk.cookeatenjoy.model.FoodInformation
import com.agobikk.cookeatenjoy.model.ModelMainCourse
import retrofit2.Response

class RemoteRepositoryImpl:RemoteRepository {
    override suspend fun getModelMainCourse(typeOfDish: String): Response<ModelMainCourse> {
        return RemoteInstance.api.getFoodMainCourse(typeOfDish = typeOfDish)
    }

    override suspend fun getFoodInformation(id: Long): Response<FoodInformation> {
        return RemoteInstance.api.getFoodInformation(id)
    }

}