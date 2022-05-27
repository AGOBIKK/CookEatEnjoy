package com.agobikk.cookeatenjoy.data.repository

import androidx.lifecycle.LiveData
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.data.local.dao.Ingredients
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val foodInformationDao: FoodInformationDao
) : LocalRepository {

    override suspend fun getFoodInfo(): LiveData<List<FoodInformationEntity>> {
        return foodInformationDao.getFoodInfo()
    }


    override suspend fun searchFoodById(searchId: Long): FoodInformationEntity {
        return foodInformationDao.searchFoodById(searchId)
    }

    override suspend fun insertFoodInfo(foodInformationEntity: FoodInformationEntity) {
        return foodInformationDao.insertFoodInfo(foodInformationEntity)
    }

    override suspend fun getIngredients(searchId: Long): Ingredients {
        return foodInformationDao.getIngredients(searchId)
    }

    override suspend fun deleteFoodInformation(foodInformationEntity: List<FoodInformationEntity>) {
        return foodInformationDao.deleteFoodInformation(foodInformationEntity)
    }


//    private var foodInformationRepo: List<FoodInformation> = emptyList()
//
//    override fun getIngredientList(recipeId:Long):List<ExtendedIngredient>{
//      return foodInformationRepo.find { it.id == recipeId }?.extendedIngredient ?: emptyList()
//    }
//
//    override fun insertFoodInfo(foodInformationEntity: FoodInformationEntity) {
//
//    }
}