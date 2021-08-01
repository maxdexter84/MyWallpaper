package ru.maxdexter.mywallpaper.ui.adapters.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.maxdexter.mywallpaper.databinding.ItemCategoryBinding
import ru.maxdexter.mywallpaper.ui.model.Category

class CategoryViewHolder(private val binding: ItemCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Category) {
        binding.tvCategory.text = item.name
    }

    companion object {
        fun create(parent: ViewGroup): CategoryViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemCategoryBinding.inflate(inflater)
            return CategoryViewHolder(binding)
        }
    }
}