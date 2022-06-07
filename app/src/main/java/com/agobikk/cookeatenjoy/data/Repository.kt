package com.agobikk.cookeatenjoy.data

import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.converters.СonverterExtendedIngredientImpl
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    remoteRepository: RemoteRepository,
    localRepository: LocalRepository
) {
    val remote = remoteRepository
    val local = localRepository

    private suspend fun readFoodInformationFromServer(id: Long): FoodInformationEntity {
        val dto = checkNotNull(remote.getFoodInformation(id).body())
        val converterFoodInformation = ConverterFoodInformationEntityImpl()
        val converterIngredients = СonverterExtendedIngredientImpl()
        val ingredients = dto.extendedIngredient.map {
            converterIngredients.convertExtendedIngredient(it)
        }
        return converterFoodInformation.convertFoodInformationEntity(dto, ingredients)
    }

    private suspend fun saveToDataBase(foodInformationEntity: FoodInformationEntity) {
        local.insertFoodInfo(foodInformationEntity)
    }

    private val readFoodInformationFromDateBase: Flow<List<FoodInformationEntity>> =
        local.getFoodInfo

    private suspend fun readIngredient(id: Long): List<ExtendedIngredientEntity> =
        local.getIngredients(id).extendedIngredientEntity

    suspend fun getFoodInfo(id: Long): Flow<List<FoodInformationEntity>> {
        return if (readFoodInformationFromDateBase != emptyList<FoodInformationEntity>()) {
            val responseFromServer = readFoodInformationFromServer(id)
            saveToDataBase(responseFromServer)
            readFoodInformationFromDateBase
        } else {
            readFoodInformationFromDateBase
        }
    }
}
