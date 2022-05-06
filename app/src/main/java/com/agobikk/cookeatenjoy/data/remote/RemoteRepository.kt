package com.agobikk.cookeatenjoy.data.remote

import com.agobikk.cookeatenjoy.data.remote.api.RemoteInstance
import com.agobikk.cookeatenjoy.model.FoodInformation
import com.agobikk.cookeatenjoy.model.ModelMainCourse
import retrofit2.Response

class RemoteRepository {
    suspend fun getModelMainCourse(): Response<ModelMainCourse> {
        return RemoteInstance.api.getFoodMainCourse()
    }

    suspend fun getFoodInformation(): Response<FoodInformation> {
        return RemoteInstance.api.getFoodInformation()
    }
}