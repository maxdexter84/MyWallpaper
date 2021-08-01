package ru.maxdexter.mywallpaper.domain.interfaces

import ru.maxdexter.mywallpaper.ui.model.Image


interface Repository {
    suspend fun getImages(category: String, pageNumber: Int, pageSize: Int):List<Image>
}