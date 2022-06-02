package com.agobikk.cookeatenjoy.data

import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.converters.СonverterExtendedIngredientImpl
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.remote.RemoteRepositoryImpl
import com.agobikk.cookeatenjoy.data.repository.LocalRepository
import com.agobikk.cookeatenjoy.data.repository.LocalRepositoryImpl
import com.agobikk.cookeatenjoy.models.FoodInformation
import javax.inject.Inject

class Repository @Inject constructor(
    remoteRepository: RemoteRepository,
    localRepository: LocalRepository
) {
    val remote = remoteRepository
    val local = localRepository

     suspend fun readFoodInformationFromServer(id:Long): FoodInformationEntity{
        val dto = checkNotNull(remote.getFoodInformation(id).body() )
         val converterFoodInformation = ConverterFoodInformationEntityImpl()
         val converterIngredients = СonverterExtendedIngredientImpl()
         val ingredients = dto.extendedIngredient.map {
             converterIngredients.convertExtendedIngredient(it)
         }
         val foodInformation =
             converterFoodInformation.convertFoodInformationEntity(dto, ingredients)
         return foodInformation
    }




}
