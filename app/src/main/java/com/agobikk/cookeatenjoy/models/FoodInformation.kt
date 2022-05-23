package com.agobikk.cookeatenjoy.models

import com.google.gson.annotations.SerializedName

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
