package com.agobikk.cookeatenjoy.data.repository

import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.converters.СonverterExtendedIngredientImpl
import com.agobikk.cookeatenjoy.data.local.dao.FavoriteRecipeDao
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.data.local.entities.Ingredients
import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import com.agobikk.cookeatenjoy.models.FoodInformation
import com.agobikk.cookeatenjoy.models.ModelMainCourse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val foodInformationDao: FoodInformationDao,
    private val favoriteRecipeDao: FavoriteRecipeDao,
    private var networkModule: ApiService
) : Repository {
    override suspend fun readFoodInformationFromServer(id: Long): FoodInformationEntity {
        val dto = checkNotNull(getFoodInformation(id).body())
        val converterFoodInformation = ConverterFoodInformationEntityImpl()
        val converterIngredients = СonverterExtendedIngredientImpl()
        val ingredients = dto.extendedIngredient.map {
            converterIngredients.convertExtendedIngredient(it)
        }
        return converterFoodInformation.convertFoodInformationEntity(dto, ingredients)
    }

    override suspend fun saveToDataBase(foodInformationEntity: FoodInformationEntity) {
        insertFoodInfo(foodInformationEntity)
    }

    override suspend fun getFoodInfo(id: Long): FoodInformationEntity {
        val item = searchFoodById(id)
        return if (item == null) {
            val responseFromServer = readFoodInformationFromServer(id)
            saveToDataBase(responseFromServer)
            responseFromServer
        } else {
            item
        }
    }

    override suspend fun getFoodInfo(): List<FoodInformationEntity> = foodInformationDao.getFoodInfo()

    override val getFavoriteFood: Flow<List<FavoriteRecipeEntity>> =
        favoriteRecipeDao.getFavoriteRecipe()


    override suspend fun searchFoodById(searchId: Long): FoodInformationEntity {
        return foodInformationDao.searchFoodById(searchId)
    }

    override suspend fun insertFoodInfo(foodInformationEntity: FoodInformationEntity) {
        return foodInformationDao.insertFoodInfo(foodInformationEntity)
    }

    override suspend fun getIngredients(searchId: Long): Ingredients {
        return foodInformationDao.getIngredients(searchId)
    }

    override suspend fun insertFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) {
        return favoriteRecipeDao.insertFavoriteRecipe(favoriteRecipeEntity)
    }

    override suspend fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) {
        return favoriteRecipeDao.deleteFavoriteRecipe(favoriteRecipeEntity)
    }

    override suspend fun deleteAllFavoriteRecipe() {
        TODO("удалить всё из вафоритов")
    }

    override suspend fun searchFavoriteRecipeById(searchId: Long): FavoriteRecipeEntity {
        TODO("поиск по id избранного")
    }

    override suspend fun getModelMainCourse(typeOfDish: String): Response<ModelMainCourse> {
        return networkModule.getFoodMainCourse(typeOfDish = typeOfDish)

    }

    override suspend fun getFoodInformation(id: Long): Response<FoodInformation> {
        return networkModule.getFoodInformation(id)
    }
}
