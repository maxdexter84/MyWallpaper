package ru.maxdexter.mywallpaper.data.repository

import ru.maxdexter.mywallpaper.data.remote.model.Hit
import ru.maxdexter.mywallpaper.data.remote.retrofit.ImageApi
import ru.maxdexter.mywallpaper.domain.common.LoadingResponse
import ru.maxdexter.mywallpaper.domain.interfaces.Repository
import ru.maxdexter.mywallpaper.domain.mappers.ResultMap
import ru.maxdexter.mywallpaper.ui.model.Image

class RepositoryImpl(private val api: ImageApi) : Repository {
    override suspend fun getImages(category: String, pageNumber: Int, pageSize: Int): List<Image> {

        return api.getImages(category,pageNumber,pageSize).hits.map {
            ResultMap.mapResultToImage(it)
        }


    }
}