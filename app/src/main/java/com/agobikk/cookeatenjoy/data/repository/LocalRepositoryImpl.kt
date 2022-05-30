package com.agobikk.cookeatenjoy.data.repository

import androidx.lifecycle.LiveData
import com.agobikk.cookeatenjoy.data.local.dao.FavoriteRecipeDao
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.data.local.dao.Ingredients
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val foodInformationDao: FoodInformationDao,
    private val favoriteRecipeDao: FavoriteRecipeDao,

) : LocalRepository {

    override val getFoodInfo: LiveData<List<FoodInformationEntity>>
        get() = foodInformationDao.getFoodInfo()

    override val getFavoriteFood: LiveData<List<FavoriteRecipeEntity>>
        get() = favoriteRecipeDao.getFavoriteRecipe()



    override suspend fun searchFoodById(searchId: Long): FoodInformationEntity {
        return foodInformationDao.searchFoodById(searchId)
    }

    override suspend fun insertFoodInfo(foodInformationEntity: FoodInformationEntity) {
        return foodInformationDao.insertFoodInfo(foodInformationEntity)
    }

    override suspend fun getIngredients(searchId: Long): Ingredients {
        return foodInformationDao.getIngredients(searchId)
    }

    override fun getFavoriteRecipe(): LiveData<List<FavoriteRecipeEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) {
        return favoriteRecipeDao.insertFavoriteRecipe(favoriteRecipeEntity)
    }

    override suspend fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) {
        return favoriteRecipeDao.deleteFavoriteRecipe(favoriteRecipeEntity)
    }

    override suspend fun deleteAllFavoriteRecipe() {
        TODO("Not yet implemented")
    }

    override suspend fun searchFavoriteRecipeById(searchId: Long): FavoriteRecipeEntity {
        TODO("Not yet implemented")
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