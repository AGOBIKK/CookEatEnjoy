package com.agobikk.cookeatenjoy.ui.screens.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.data.local.entities.FavoriteRecipeEntity
import com.agobikk.cookeatenjoy.databinding.LayoutRecipeListItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class FavoriteAdapter(private val onClickListener: OnFavoriteClickListener) :
    ListAdapter<FavoriteRecipeEntity, FavoriteAdapter.FavoriteRecipeViewHolder>(FavoriteDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteRecipeViewHolder =
        FavoriteRecipeViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_recipe_list_item, parent, false)
        )


    override fun onBindViewHolder(holder: FavoriteRecipeViewHolder, position: Int) {
        holder.cardView.animation =
            AnimationUtils.loadAnimation(holder.cardView.context, R.anim.anim_item)
        val item = getItem(position)
        holder.itemView.setOnClickListener { onClickListener.onClick(item) }
        holder.bind(item)

    }

    inner class FavoriteRecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: CardView = itemView.findViewById(R.id.card_view)
        private val viewBinding: LayoutRecipeListItemBinding by viewBinding()

        fun bind(recipe: FavoriteRecipeEntity) = with(viewBinding) {
            recipeListTitleTextView.text = recipe.title
            recipeListImage.apply {
                Glide
                    .with(context)
                    .setDefaultRequestOptions(
                        RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                            .error(R.drawable.ic_broken_image)
                    )
                    .load(recipe.image)
                    .into(this)
            }
        }
    }

}

