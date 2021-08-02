package ru.maxdexter.mynews.ui.adapters.newsadapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.maxdexter.mywallpaper.ui.adapters.image.ImageViewHolder
import ru.maxdexter.mywallpaper.ui.model.Image


class ImageAdapter : PagingDataAdapter<Image, ImageViewHolder>(diffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
       return ImageViewHolder.from(parent)
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