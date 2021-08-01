package ru.maxdexter.mywallpaper.ui.adapters.category

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.maxdexter.mywallpaper.ui.model.Category

class CategoryAdapter(private val click: (String) -> Unit) :
    RecyclerView.Adapter<CategoryViewHolder>() {
    private val categoryList = mutableListOf<Category>()
    fun submitList(list: List<Category>) {
        if (list.isNotEmpty()) {
            categoryList.clear()
            categoryList.addAll(list)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val vh = CategoryViewHolder.create(parent)
        vh.itemView.setOnClickListener {
            click.invoke(categoryList[vh.adapterPosition].name)
        }
        return vh
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList.get(position))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}