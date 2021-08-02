package ru.maxdexter.mywallpaper.ui.adapters.image

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.maxdexter.mywallpaper.databinding.ItemImageBinding
import ru.maxdexter.mywallpaper.ui.model.Image
import ru.maxdexter.mywallpaper.utils.setImage

class ImageViewHolder(private val binding: ItemImageBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(image: Image) {
        binding.ivPrev.setImage(image.previewURL)

    }

    companion object {
        fun from(parent: ViewGroup): ImageViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemImageBinding.inflate(layoutInflater, parent, false)
            return ImageViewHolder(binding)
        }
    }
}