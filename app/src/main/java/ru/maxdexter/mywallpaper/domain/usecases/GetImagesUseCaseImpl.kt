package ru.maxdexter.mywallpaper.domain.usecases

import ru.maxdexter.mywallpaper.domain.interfaces.Repository
import ru.maxdexter.mywallpaper.ui.model.Image

class GetImagesUseCaseImpl(private val repository: Repository) : GetImagesUseCase {
    override suspend fun getAllImages(
        category: String,
        pageNumber: Int,
        pageSize: Int
    ): List<Image> {
        return repository.getImages(category, pageNumber, pageSize)
    }
}