package com.agobikk.cookeatenjoy

import com.agobikk.cookeatenjoy.data.converters.ConverterFoodInformationEntityImpl
import com.agobikk.cookeatenjoy.data.converters.СonvertExtendedIngredient
import com.agobikk.cookeatenjoy.data.converters.СonverterExtendedIngredientImpl
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ExtendedIngredient
import com.nhaarman.mockito_kotlin.isA

import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.*

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

    @Test
    fun argumentExtendedIngredientTest() {
        val c = mock(СonvertExtendedIngredient::class.java)
        val extendedIngredientResults = mock(ExtendedIngredient::class.java)
        val extendedIngredientEntityResult = mock(ExtendedIngredientEntity::class.java)
        Mockito.`when`(c.convertExtendedIngredient(extendedIngredientResults)).thenReturn(extendedIngredientEntityResult)
        assertEquals(c.convertExtendedIngredient(extendedIngredientResults),extendedIngredientEntityResult)
        verify(c, times(1)).convertExtendedIngredient(extendedIngredientResults)

    }
}