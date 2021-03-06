package com.agobikk.cookeatenjoy.data.converters

import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.converters.–°onverterExtendedIngredientImpl
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import com.agobikk.cookeatenjoy.models.FoodInformation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class –°onverterExtendedIngredientImplTest {

    @Test
    fun `should return correct data`() {
        val useCase = –°onverterExtendedIngredientImpl()
        val extendedIngredientEntity =
            ExtendedIngredientEntity(
                1,
                1.0,
                "consistency",
                "image",
                "name",
                "original",
                "unit"
            )


        val extendedIngredient =
            ExtendedIngredient(
                1,
                1.0,
                "consistency",
                "image",
                "name",
                "original",
                "unit"
            )

        val expected =
            useCase.convertExtendedIngredient(extendedIngredient)

        val actual = extendedIngredientEntity
        Assertions.assertEquals(expected, actual)
    }
}