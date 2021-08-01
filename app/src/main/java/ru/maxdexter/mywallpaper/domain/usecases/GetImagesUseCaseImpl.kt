package ru.maxdexter.mywallpaper.domain.usecases

import ru.maxdexter.mywallpaper.domain.common.LoadingResponse
import ru.maxdexter.mywallpaper.domain.interfaces.Repository

class GetImagesUseCaseImpl(private val repository: Repository) : GetImagesUseCase {
    override suspend fun getAllImages(
        category: String,
        pageNumber: Int,
        pageSize: Int
    ): LoadingResponse {
        return repository.getImages(category, pageNumber, pageSize)
    }
}