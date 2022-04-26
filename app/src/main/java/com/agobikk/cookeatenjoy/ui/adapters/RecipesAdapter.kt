package com.agobikk.cookeatenjoy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.LayoutRecipeListItemBinding
import com.agobikk.cookeatenjoy.model.RecipeList
import com.agobikk.cookeatenjoy.ui.screens.RecipeListFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlin.math.roundToInt

class RecipesAdapter(private val onClickListener: RecipeListFragment.OnClickListener) :
    ListAdapter<RecipeList, RecipesAdapter.RecipeViewHolder>(RecipeDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
        RecipeViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_recipe_list_item, parent, false)
        )


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener { onClickListener.onClick(item) }
        holder.bind(item)
    }


class RecipeViewHolder (temView: View) : RecyclerView.ViewHolder(temView) {

        private val viewBinding: LayoutRecipeListItemBinding by viewBinding()

        fun bind(recipe: RecipeList) = with(viewBinding) {
            recipeListTitleTextView.text = recipe.title
            descriptionTextView.text = recipe.description
            maxReadyTimeTextView.text = recipe.maxReadyTime.roundToInt().toString()
            recipeListImage.apply {
                Glide
                    .with(context)
                    .setDefaultRequestOptions(
                        RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                            .error(R.drawable.ic_broken_image)
                    )
                    .load(recipe.imageUrl)
                    .into(this)
            }
        }
    }
}


