package ru.maxdexter.mywallpaper.domain.usecases

import ru.maxdexter.mywallpaper.ui.model.Image

interface GetImagesUseCase {
    suspend fun getAllImages(category: String, pageNumber: Int, pageSize: Int): List<Image>
}