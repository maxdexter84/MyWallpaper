package ru.maxdexter.mywallpaper.ui.adapters.image

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.maxdexter.mywallpaper.ui.model.Image


class ImageAdapter(private val click:(String)-> Unit) : PagingDataAdapter<Image, ImageViewHolder>(diffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
        val vh = ImageViewHolder.from(parent)
        vh.itemView.setOnClickListener {
            getItem(vh.absoluteAdapterPosition)?.largeImageURL?.let { url -> click.invoke(url) }
        }
       return vh
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = getItem(position)
        if (image != null) {
            holder.bind(image)
        }
    }

    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<Image>(){
            override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem.largeImageURL == newItem.largeImageURL
            }

            override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
                return  oldItem == newItem
            }
        }
    }
}