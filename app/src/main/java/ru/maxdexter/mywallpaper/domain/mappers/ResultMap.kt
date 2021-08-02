package ru.maxdexter.mywallpaper.domain.mappers

import ru.maxdexter.mywallpaper.data.remote.model.Hit
import ru.maxdexter.mywallpaper.ui.model.Image

class ResultMap {
    companion object {
        fun mapResultToImage(hit: Hit): Image {
            return Image(
                hit.id ?: 0,
                hit.largeImageURL ?: "",
                hit.pageURL ?: "",
                hit.webformatURL ?:"",
                hit.tags ?: "",
                hit.type ?: "",
                hit.webformatURL ?: ""
            )
        }
    }
}