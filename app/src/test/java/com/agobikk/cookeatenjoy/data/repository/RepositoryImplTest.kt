package com.agobikk.cookeatenjoy.data.repository

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.converters.СonverterExtendedIngredientImpl
import com.agobikk.cookeatenjoy.data.local.dao.FavoriteRecipeDao
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao_Impl
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import com.agobikk.cookeatenjoy.models.FoodInformation
import com.agobikk.cookeatenjoy.models.ModelMainCourse
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import retrofit2.Response


class RepositoryImplTest {
    @BeforeEach
    fun beforeEach() {
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }

        })
    }

    @AfterEach
    fun afterEach() {
        Mockito.reset(foodInformationDao)
        Mockito.reset(favoriteRecipeDao)
        Mockito.reset(networkModule)
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

    private val foodInformationDao = mock<FoodInformationDao>()
    private val favoriteRecipeDao = mock<FavoriteRecipeDao>()
    private val networkModule = mock<ApiService>()


    @Test
    fun `should return List FoodInformationEntity when we call method getFoodInfo`() {
        runBlocking {
            val foodInformationEntity = listOf(
                FoodInformationEntity(
                    0, "", "", "", "",
                    emptyList()
                )
            )
            Mockito.`when`(foodInformationDao.getFoodInfo()).thenReturn(foodInformationEntity)
            val actual = foodInformationDao.getFoodInfo()

            val expected = foodInformationEntity
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun `should return empty response from server when we call method getFoodInformation`() {
        runBlocking {
            val repository = mock<RepositoryImpl>()
            val response = Mockito.mock(Response::class.java) as Response<*>
            Mockito.`when`(networkModule.getFoodInformation(Mockito.anyLong())).thenReturn(null)
            val actual = repository.getFoodInformation(1)
            assertNull(response.body())
            assertNull(actual)
        }
    }

    @Test
    fun `should return not empty response from server when we call method getFoodInformation`() {
        runBlocking {
            val repository = mock<RepositoryImpl>()
            val response = mock<Response<FoodInformation>>()
            val foodInformation =
                FoodInformation(
                    0, "", "", "", "",
                    emptyList()
                )
            Mockito.`when`(response.body()).thenReturn(foodInformation)
            val actual = response.body()
            repository.getFoodInformation(Mockito.anyLong())
            assertNotNull(actual)
        }
    }

    @Test
    fun `should return empty response from server when we call method getFoodMainCourse`() {
        runBlocking {
            val dish = "Main course"
            val repository = mock<RepositoryImpl>()
            val response = Mockito.mock(Response::class.java) as Response<*>
            Mockito.`when`(networkModule.getFoodMainCourse(dish)).thenReturn(null)
            repository.getModelMainCourse(dish)
            assertNull(response.body())
        }
    }

    @Test
    fun `should return not empty response from server when we call method getFoodMainCourse`() {
        runBlocking {
            val repository = mock<RepositoryImpl>()
            val response = mock<Response<ModelMainCourse>>()
            val dish = "Main course"
            val fakeResponseMainCourse =
                ModelMainCourse(
                    number = 1,
                    offset = 1,
                    results = emptyList(),
                    totalResults = 1

                )
            Mockito.`when`(response.body()).thenReturn(fakeResponseMainCourse)
            val actual = response.body()
            repository.getModelMainCourse(dish)
            assertNotNull(actual)
        }
    }
}







