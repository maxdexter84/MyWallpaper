package ru.maxdexter.mywallpaper.domain.interfaces

import ru.maxdexter.mywallpaper.data.remote.model.Hit
import ru.maxdexter.mywallpaper.domain.common.LoadingResponse
import ru.maxdexter.mywallpaper.ui.model.Image


interface Repository {
    suspend fun getImages(category: String, pageNumber: Int, pageSize: Int): List<Image>
}