package com.agobikk.cookeatenjoy.data.local.entities

import androidx.room.*
import com.agobikk.cookeatenjoy.data.local.RoomConstants

@Entity(tableName = RoomConstants.FOOD_INFO_TABLE)
data class FoodInformation(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id food")
    var id: Long,

    @ColumnInfo(name = "image food")
    var image: String,

    @ColumnInfo(name = "summary food")
    var instructions: String,

    @ColumnInfo(name = "title food")
    var title: String,

    @ColumnInfo(name = "sourceName food")
    var sourceName: String,

    @ColumnInfo(name = "extended_ingredients")
    var extendedIngredientEntity: List<ExtendedIngredientEntity>
)

data class ExtendedIngredientEntity(

    @ColumnInfo(name = "id ingredient")
    var idExtendedIngredient: Long,

    @ColumnInfo(name = "amount ingredient")
    var amount: Double?,

    @ColumnInfo(name = "consistency_ingredient")
    var consistency: String?,

    @ColumnInfo(name = "image ingredient")
    var image_ingredient: String?,

    @ColumnInfo(name = "name ingredient")
    var name: String?,

    @ColumnInfo(name = "original ingredient")
    var original: String?,

    @ColumnInfo(name = "unit ingredient")
    var unit: String?
)


