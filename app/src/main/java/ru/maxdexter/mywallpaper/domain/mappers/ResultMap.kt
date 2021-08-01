package ru.maxdexter.mywallpaper.domain.mappers

import ru.maxdexter.mywallpaper.data.remote.model.Hit
import ru.maxdexter.mywallpaper.ui.model.Image

class ResultMap {
    companion object {
        fun mapResultToImage(hit: Hit): Image {
            return Image(
                hit.id,
                hit.largeImageURL,
                hit.pageURL,
                hit.previewURL,
                hit.tags,
                hit.type,
                hit.webformatURL
            )
        }
    }
}