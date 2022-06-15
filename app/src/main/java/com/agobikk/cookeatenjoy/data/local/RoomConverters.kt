package com.agobikk.cookeatenjoy.data.local

import androidx.room.TypeConverter
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class RoomConverters {
    private val gson = Gson()

    @TypeConverter
    fun toJson(segments: List<ExtendedIngredientEntity>?): String? {
        return gson.toJson(segments)
    }

    @TypeConverter
    fun formJson(json: String?): List<ExtendedIngredientEntity>? {
        return gson.fromJson<List<ExtendedIngredientEntity>>(
            json,
            object : TypeToken<List<ExtendedIngredientEntity>?>() {}.type
        )
    }



}