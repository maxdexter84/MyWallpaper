package ru.maxdexter.mywallpaper.data.repository

import ru.maxdexter.mywallpaper.domain.interfaces.Repository
import ru.maxdexter.mywallpaper.ui.model.Image

class RepositoryImpl(): Repository {
    override suspend fun getImages(category: String, pageNumber: Int, pageSize: Int): List<Image> {
        TODO("Not yet implemented")
    }
}