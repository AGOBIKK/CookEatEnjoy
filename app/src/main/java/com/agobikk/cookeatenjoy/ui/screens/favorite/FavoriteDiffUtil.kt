package com.agobikk.cookeatenjoy.ui.screens.favorite

import androidx.recyclerview.widget.DiffUtil
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.ResultMainCourse

class FavoriteDiffUtil : DiffUtil.ItemCallback<FoodInformationEntity>() {
    override fun areItemsTheSame(oldItem: FoodInformationEntity, newItem: FoodInformationEntity) =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: FoodInformationEntity, newItem: FoodInformationEntity) =
        oldItem == newItem

}