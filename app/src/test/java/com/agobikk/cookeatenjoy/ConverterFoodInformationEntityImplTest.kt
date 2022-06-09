package com.agobikk.cookeatenjoy

import com.agobikk.cookeatenjoy.data.converters.ConvertFoodInformationEntity
import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.converters.СonvertExtendedIngredient
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import com.agobikk.cookeatenjoy.models.FoodInformation
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class ConverterFoodInformationEntityImplTest {
    private lateinit var converterFoodInformationEntityImplTest: ConverterFoodInformationEntityImpl
    private var extendedIngredientEntity = listOf(
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

    private var extendedIngredient = listOf(
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
    private var foodInformation =
        FoodInformation(
            1,
            "image",
            "instructions",
            "title",
            "sourceName", extendedIngredient
        )



    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        converterFoodInformationEntityImplTest = ConverterFoodInformationEntityImpl()
    }

    @Test
    fun convertFoodInformationEntity_test() {
        assertEquals(returnFoodInformation(),converterFoodInformationEntity())
    }

    @Test
    fun argumentExtendedIngredientTest() {
        val c = Mockito.mock(ConvertFoodInformationEntity::class.java)
        val foodInformationResults = Mockito.mock(FoodInformation::class.java)
        val extendedIngredientResults = listOf(Mockito.mock(ExtendedIngredientEntity::class.java))
        val foodInformationEntityResult = Mockito.mock(FoodInformationEntity::class.java)
        Mockito.`when`(c.convertFoodInformationEntity(foodInformationResults,extendedIngredientResults)).thenReturn(foodInformationEntityResult)
        assertEquals(c.convertFoodInformationEntity(foodInformationResults,extendedIngredientResults),foodInformationEntityResult)
        verify(c, times(1)).convertFoodInformationEntity(foodInformationResults,extendedIngredientResults)

    }

    private fun returnFoodInformation(): FoodInformationEntity {
        return FoodInformationEntity(
                1,
                "image",
                "instructions",
                "title",
                "sourceName",
                listOf(
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
            )


    }

    private fun converterFoodInformationEntity():FoodInformationEntity{
       return converterFoodInformationEntityImplTest.convertFoodInformationEntity(foodInformation,extendedIngredientEntity)
    }
}

