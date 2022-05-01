package com.agobikk.cookeatenjoy.model


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

