package com.agobikk.cookeatenjoy.model

import com.google.gson.annotations.SerializedName


data class DetailRecipe(

    val imageUrl: String,
    val recipeId: String,
    val title: String,
    val sourceName: String,
    val instructions: String,
    val favorite: Boolean = false
)

data class Category(
    val categoryName: String,
    val imageUrl: Int
)


data class RecipeList(
    val recipeId: String,
    val title: String,
    val description: String,
    val maxReadyTime: Float,
    val imageUrl: String,
    val vegan: Boolean
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
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("title")
    val title: String
)

data class FoodInformation(

    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,

    @SerializedName("summary")
    val instructions: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("sourceName")
    val sourceName: String,
)

data class ExtendedIngredient(
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

