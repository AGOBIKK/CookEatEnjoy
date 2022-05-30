package com.agobikk.cookeatenjoy.data.local.entities

import androidx.room.*
import com.agobikk.cookeatenjoy.data.local.RoomConstants

@Entity(tableName = RoomConstants.FOOD_INFO_TABLE)
data class FoodInformationEntity(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id_food")
    var id: Long,

    @ColumnInfo(name = "image_food")
    var image: String,

    @ColumnInfo(name = "summary_food")
    var instructions: String?,

    @ColumnInfo(name = "title_food")
    var title: String,

    @ColumnInfo(name = "source_name_food")
    var sourceName: String?,

    @ColumnInfo(name = "extended_ingredients")
    var extendedIngredientEntity: List<ExtendedIngredientEntity>
)




