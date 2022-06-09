package com.agobikk.cookeatenjoy

import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.converters.СonverterExtendedIngredientImpl
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import org.junit.Assert.*

class СonverterExtendedIngredientImplTest {
    private lateinit var converterExtendedIngredientImplTest: СonverterExtendedIngredientImpl

    private var extendedIngredient =
        ExtendedIngredient(
            1,
            1.0,
            "consistency",
            "image",
            "name",
            "original",
            "unit"
        )

    private var extendedIngredientEntity =
        ExtendedIngredientEntity(
            1,
            1.0,
            "consistency",
            "image",
            "name",
            "original",
            "unit"
        )


    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        converterExtendedIngredientImplTest = СonverterExtendedIngredientImpl()
    }


    @Test
    fun convertExtendedIngredientTest() {
        assertEquals(extendedIngredientEntity, converterToIngredientEntity())
    }

    private fun converterToIngredientEntity(): ExtendedIngredientEntity {
        return converterExtendedIngredientImplTest.convertExtendedIngredient(extendedIngredient)
    }
}