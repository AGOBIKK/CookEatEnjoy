package com.agobikk.cookeatenjoy.data.remote

import com.agobikk.cookeatenjoy.data.remote.api.RemoteInstance
import com.agobikk.cookeatenjoy.model.FoodInformation
import com.agobikk.cookeatenjoy.model.ModelMainCourse
import retrofit2.Response

class RemoteRepository {
    suspend fun getModelMainCourse(typeOfDish: String): Response<ModelMainCourse> {
        return RemoteInstance.api.getFoodMainCourse(typeOfDish = typeOfDish)
    }

    suspend fun getFoodInformation(id: Int): Response<FoodInformation> {
        return RemoteInstance.api.getFoodInformation(id = id)
    }

}