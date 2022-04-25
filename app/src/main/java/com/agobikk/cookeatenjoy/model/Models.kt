package com.agobikk.cookeatenjoy.model


data class Category(
    val categoryName: String,
    val imageUrl: Int
)


data class RecipeList(
    val recipeId: String,
    val title: String,
    val description: String,
    val maxReadyTime: Float,
    val imageUrl: String
)