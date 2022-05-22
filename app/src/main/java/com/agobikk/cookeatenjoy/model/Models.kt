package com.agobikk.cookeatenjoy.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName




data class Category(
    val categoryName: String,
    val imageUrl: Int
)

data class ModelMainCourse(
    @SerializedName("number")
    val number: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<ResultMainCourse>,
    @SerializedName("totalResults")
    val totalResults: Int)

data class ResultMainCourse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("image")
    val image: String,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("title")
    val title: String
)


data class FoodInformation(
    @SerializedName("id")
    val id: Long,
    @SerializedName("image")
    val image: String,
    @SerializedName("summary")
    val instructions: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("sourceName")
    val sourceName: String,
    @SerializedName("extendedIngredients")
    val extendedIngredient: List<ExtendedIngredient>,
)


data class ExtendedIngredient(
    @SerializedName("id")
    val idExtendedIngredient: Long,
    @SerializedName("amount")
    val amount: Double?,
    @SerializedName("consistency")
    val consistency: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("original")
    val original: String?,
    @SerializedName("unit")
    val unit: String?
)

