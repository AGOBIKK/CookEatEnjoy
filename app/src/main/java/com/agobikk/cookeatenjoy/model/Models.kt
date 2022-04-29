package com.agobikk.cookeatenjoy.model

data class DetailRecipe(
    val title: String,
    val image: String,
    val instructions: String,
    val extendedIngredients: String
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