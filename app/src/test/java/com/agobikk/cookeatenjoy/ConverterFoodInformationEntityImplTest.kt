package com.agobikk.cookeatenjoy

import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import com.agobikk.cookeatenjoy.models.FoodInformation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class ConverterFoodInformationEntityImplTest {

    @Test
    fun `should return correct data`() {
        val useCase = ConverterFoodInformationEntityImpl()
        val extendedIngredientEntity = listOf(
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
        val foodInformationEntity =
            FoodInformationEntity(
                1,
                "image",
                "instructions",
                "title",
                "sourceName", extendedIngredientEntity = extendedIngredientEntity
            )
        val extendedIngredient = listOf(
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
        val foodInformation =
            FoodInformation(
                1,
                "image",
                "instructions",
                "title",
                "sourceName", extendedIngredient = extendedIngredient
            )

        val expected =
            useCase.convertFoodInformationEntity(foodInformation, extendedIngredientEntity)

        val actual = foodInformationEntity
        Assertions.assertEquals(expected, actual)
    }
}

