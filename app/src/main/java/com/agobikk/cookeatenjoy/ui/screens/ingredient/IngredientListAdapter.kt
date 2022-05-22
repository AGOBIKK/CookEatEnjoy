package com.agobikk.cookeatenjoy.ui.screens.ingredient

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.aplication.di.NetworkConstants
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.databinding.LayoutIngredientsItemBinding
import com.bumptech.glide.Glide


class IngredientListAdapter(private val onIngredientClickListener: OnIngredientClickListener) :
    ListAdapter<ExtendedIngredientEntity, IngredientListAdapter.IngredientViewHolder>(IngredientDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder =
        IngredientViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_ingredients_item, parent, false)
        )

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.cardView.animation =
            AnimationUtils.loadAnimation(holder.cardView.context, R.anim.anim_item)
        val item = getItem(position)
        holder.itemView.setOnClickListener { onIngredientClickListener.onClick(item) }
        holder.bind(item)

    }




    class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: CardView = itemView.findViewById(R.id.ingredients_cardView)

        private val viewBinding: LayoutIngredientsItemBinding by viewBinding()
        fun bind(extendedIngredient: ExtendedIngredientEntity) = with(viewBinding) {
            ingredientName.text = extendedIngredient.name
            ingredientAmount.text = extendedIngredient.amount.toString()
            ingredientUnit.text = extendedIngredient.unit
            ingredientConsistency.text = extendedIngredient.consistency
            ingredientOriginal.text = extendedIngredient.original
            ingredientImageView.apply {
                Glide
                    .with(context)
                    .load(NetworkConstants.BASE_IMAGE_URL + extendedIngredient.image_ingredient)
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
                    .into(this)
            }
        }
    }
}
