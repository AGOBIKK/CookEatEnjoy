package com.agobikk.cookeatenjoy.model

import com.google.gson.annotations.SerializedName


data class DetailRecipe(
    val analyzedInstructions: Array<String>?,
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

