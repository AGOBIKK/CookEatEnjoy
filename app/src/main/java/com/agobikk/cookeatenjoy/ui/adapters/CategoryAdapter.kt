package com.agobikk.cookeatenjoy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.agobikk.cookeatenjoy.R
import com.agobikk.cookeatenjoy.databinding.LayoutCategoryListItemBinding
import com.agobikk.cookeatenjoy.model.Category
import com.agobikk.cookeatenjoy.model.RecipeList
import com.bumptech.glide.Glide

class CategoryAdapter(val onCategoryClick: OnCategoryClick) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


     var categoryData = listOf<Category>()
        set(value) {
            field = value
            notifyItemChanged(itemCount)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_category_list_item, parent, false)
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = categoryData[position]
        holder.bind(onCategoryClick, item)
    }

    override fun getItemCount() = categoryData.size

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding: LayoutCategoryListItemBinding by viewBinding()

        fun bind(categoryClick: OnCategoryClick, item: Category) = with(viewBinding) {
            categoryTitle.text = item.categoryName
            categoryImage.apply {
                Glide
                    .with(context)
                    .load(item.imageUrl)
                    .into(this)
            }
            itemView.setOnClickListener { categoryClick.onClick(item) }
        }
    }
}

class OnCategoryClick(val clickListener: (string: String) -> Unit) {
    fun onClick(category: Category) = clickListener(category.categoryName)
}
