package com.agobikk.cookeatenjoy.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.agobikk.cookeatenjoy.data.local.RoomConstants


@Entity(tableName = RoomConstants.FAVORITE_RECIPES_TABLE)
data class FavoriteRecipeEntity  (
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id_food")
    var id: Long,

    @ColumnInfo(name = "image_food")
    var image: String,


    @ColumnInfo(name = "title_food")
    var title: String,
        )