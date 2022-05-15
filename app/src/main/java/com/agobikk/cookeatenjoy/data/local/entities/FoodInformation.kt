package com.agobikk.cookeatenjoy.data.local.entities

import androidx.room.*
import com.agobikk.cookeatenjoy.data.local.RoomConstants

import com.google.gson.annotations.SerializedName

@Entity(tableName = RoomConstants.FOOD_INFO_TABLE)
data class FoodInformation(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id food")
    @SerializedName("id")
    var id: Int,

    @ColumnInfo(name = "image food")
    @SerializedName("image")
    var image: String,

    @ColumnInfo(name = "summary food")
    @SerializedName("summary")
    var instructions: String,

    @ColumnInfo(name = "title food")
    @SerializedName("title")
    var title: String,

    @ColumnInfo(name = "sourceName food")
    @SerializedName("sourceName")
    var sourceName: String,

    @Embedded
    @SerializedName("extendedIngredients")
    var extendedIngredient: ExtendedIngredient
) {
    constructor() : this(
        0, "", "", "", "", extendedIngredient = ExtendedIngredient()
    )
}

data class ExtendedIngredient(

    @ColumnInfo(name = "id ingredient")
    @SerializedName("id")
    var idExtendedIngredient: Int?,

    @ColumnInfo(name = "amount ingredient")
    @SerializedName("amount")
    var amount: Double?,

    @ColumnInfo(name = "consistency ingredient")
    @SerializedName("consistency ")
    var consistency: String?,

    @ColumnInfo(name = "image ingredient")
    @SerializedName("image")
    var image_ingredient: String?,

    @ColumnInfo(name = "name ingredient")
    @SerializedName("name")
    var name: String?,

    @ColumnInfo(name = "original ingredient")
    @SerializedName("original")
    var original: String?,

    @ColumnInfo(name = "unit ingredient")
    @SerializedName("unit")
    var unit: String?
) {
    constructor() : this(0, 0.0, "", "", "", "", "")
}


