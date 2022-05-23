package com.agobikk.cookeatenjoy.models

import com.google.gson.annotations.SerializedName

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
