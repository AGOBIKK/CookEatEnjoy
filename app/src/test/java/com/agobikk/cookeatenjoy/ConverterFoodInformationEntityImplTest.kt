package com.agobikk.cookeatenjoy

import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import com.agobikk.cookeatenjoy.models.FoodInformation
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
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
        assertEquals(buildFoodInformation(),converter())
    }

    private fun buildFoodInformation(): FoodInformationEntity {
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

    private fun converter():FoodInformationEntity{
       return converterFoodInformationEntityImplTest.convertFoodInformationEntity(foodInformation,extendedIngredientEntity)
    }
}

