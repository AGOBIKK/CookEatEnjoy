package com.agobikk.cookeatenjoy.data.local.entities

import androidx.room.ColumnInfo

data class ExtendedIngredientEntity(

    @ColumnInfo(name = "id_ingredient")
    var idExtendedIngredient: Long,

    @ColumnInfo(name = "amount_ingredient")
    var amount: Double?,

    @ColumnInfo(name = "consistency_ingredient")
    var consistency: String?,

    @ColumnInfo(name = "image_ingredient")
    var image_ingredient: String?,

    @ColumnInfo(name = "name_ingredient")
    var name: String?,

    @ColumnInfo(name = "original_ingredient")
    var original: String?,

    @ColumnInfo(name = "unit_ingredient")
    var unit: String?
)
