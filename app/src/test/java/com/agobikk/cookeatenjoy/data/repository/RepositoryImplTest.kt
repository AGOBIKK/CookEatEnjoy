package com.agobikk.cookeatenjoy.data.repository

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.agobikk.cookeatenjoy.data.local.dao.FavoriteRecipeDao
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao
import com.agobikk.cookeatenjoy.data.local.dao.FoodInformationDao_Impl
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.data.remote.api.ApiService
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import com.agobikk.cookeatenjoy.models.FoodInformation
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify


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
//        Mockito.reset(repository)
        ArchTaskExecutor.getInstance().setDelegate(null)
    }


    private val extendedIngredientEntity = listOf(
        ExtendedIngredientEntity(
            1,
            1.0,
            "consistency",
            "image",
            "name",
            "original",
            "unit"
        )
    )
    private val extendedIngredient = listOf(
        ExtendedIngredient(
            1,
            1.0,
            "consistency",
            "image",
            "name",
            "original",
            "unit"
        )
    )
    private val foodInformationEntity =
        listOf(
            FoodInformationEntity(
                1,
                "image",
                "instructions",
                "title",
                "sourceName",
                extendedIngredientEntity = extendedIngredientEntity
            )
        )

    private val foodInformation =
        FoodInformation(
            1,
            "image",
            "instructions",
            "title",
            "sourceName",
            extendedIngredient = extendedIngredient
        )
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
}







