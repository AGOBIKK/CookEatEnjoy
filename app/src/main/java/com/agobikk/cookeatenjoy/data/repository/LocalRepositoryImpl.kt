package com.agobikk.cookeatenjoy.data.repository

import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.data.local.dao.Ingredients
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import com.agobikk.cookeatenjoy.models.FoodInformation
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val foodInformationDao: FoodInformationDao
) : LocalRepository{

    override suspend fun searchFoodById(searchId: Long): FoodInformationEntity{
        return foodInformationDao.searchFoodById(searchId)
    }

    override suspend fun insertFoodInfo(foodInformationEntity: FoodInformationEntity){
        return foodInformationDao.insertFoodInfo(foodInformationEntity)
    }

    override suspend fun getIngredients(searchId: Long): Ingredients {
        return foodInformationDao.getIngredients(searchId)
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