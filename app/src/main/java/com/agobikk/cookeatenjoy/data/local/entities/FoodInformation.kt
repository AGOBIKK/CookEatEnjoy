package com.agobikk.cookeatenjoy.data.local.entities

import androidx.room.*
import com.agobikk.cookeatenjoy.data.local.RoomConstants

import com.google.gson.annotations.SerializedName

@Entity(tableName = RoomConstants.FOOD_INFO_TABLE)
data class FoodInformation(
    @PrimaryKey
    @SerializedName("id")
    var id: Int,

    @ColumnInfo
    @SerializedName("image")
    var image: String,

    @ColumnInfo
    @SerializedName("summary")
    var instructions: String,

    @ColumnInfo
    @SerializedName("title")
    var title: String,

    @ColumnInfo
    @SerializedName("sourceName")
    var sourceName: String,

    @Ignore
    @SerializedName("extendedIngredients")
    var extendedIngredient: List<ExtendedIngredient>,
){
    constructor() : this(0,"","","","", extendedIngredient = emptyList())
}


data class ExtendedIngredient(

    @ColumnInfo
    @SerializedName("id")
    var idExtendedIngredient: Int,

    @ColumnInfo
    @SerializedName("amount")
    var amount: Double?,

    @ColumnInfo
    @SerializedName("consistency")
    var consistency: String?,

    @ColumnInfo
    @SerializedName("image")
    var image: String?,

    @ColumnInfo
    @SerializedName("name")
    var name: String?,

    @ColumnInfo
    @SerializedName("original")
    var original: String?,

    @ColumnInfo
    @SerializedName("unit")
    var unit: String?
){
    constructor() : this(0,0.0,"","","","","")
}


