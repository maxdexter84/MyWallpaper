package ru.maxdexter.mywallpaper.domain.usecases

import ru.maxdexter.mywallpaper.data.remote.retrofit.ImageApi
import ru.maxdexter.mywallpaper.domain.common.LoadingResponse
import ru.maxdexter.mywallpaper.ui.model.Image

interface GetImagesUseCase {
    suspend fun getAllImages(category: String, pageNumber: Int, pageSize: Int): LoadingResponse
}