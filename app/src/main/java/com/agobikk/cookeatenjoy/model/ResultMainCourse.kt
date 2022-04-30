package com.agobikk.cookeatenjoy.model


import com.google.gson.annotations.SerializedName

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