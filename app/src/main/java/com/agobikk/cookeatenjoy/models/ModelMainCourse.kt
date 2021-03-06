package com.agobikk.cookeatenjoy.models

import com.google.gson.annotations.SerializedName

data class ModelMainCourse(
    @SerializedName("number")
    val number: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<ResultMainCourse>,
    @SerializedName("totalResults")
    val totalResults: Int)
