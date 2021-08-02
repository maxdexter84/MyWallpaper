package ru.maxdexter.mywallpaper.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.maxdexter.mywallpaper.R

fun <T> ImageView.setImage(uri: T) {
    Glide.with(this.context)
        .load(uri).apply(
            RequestOptions().placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_brocken_img)
        ).diskCacheStrategy(
            DiskCacheStrategy.ALL
        ).into(this)
}