package com.agobikk.cookeatenjoy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.LayoutRecipeListItemBinding
import com.agobikk.cookeatenjoy.model.RecipeList
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlin.math.roundToInt

class RecipeListAdapter(val recipeClick: OnRecipeClick) :
    RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder>() {

    var recipeListData = listOf<RecipeList>()
        set(value) {
            field = value
            notifyItemChanged(itemCount)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder =
        RecipeListViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_recipe_list_item, parent, false)
        )

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        val item = recipeListData[position]
        holder.bind(recipeClick, item)
    }

    override fun getItemCount(): Int = recipeListData.size

    class RecipeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding: LayoutRecipeListItemBinding by viewBinding()

        fun bind(recipeClick: OnRecipeClick, recipe: RecipeList) = with(viewBinding) {
            itemView.setOnClickListener { recipeClick.onClick(recipe) }
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

class OnRecipeClick(val clickListener: (id: String) -> Unit) {
    fun onClick(recipe: RecipeList) = clickListener(recipe.recipeId)
}