package ru.maxdexter.mywallpaper.data.repository

import ru.maxdexter.mywallpaper.data.remote.retrofit.ImageApi
import ru.maxdexter.mywallpaper.domain.common.LoadingResponse
import ru.maxdexter.mywallpaper.domain.interfaces.Repository
import ru.maxdexter.mywallpaper.domain.mappers.ResultMap
import ru.maxdexter.mywallpaper.ui.model.Image

class RepositoryImpl(private val api: ImageApi) : Repository {
    override suspend fun getImages(category: String, pageNumber: Int, pageSize: Int): LoadingResponse {
        var response: LoadingResponse = LoadingResponse.Loading
        api.runCatching {
            getImages(category = category, page = pageNumber, perPage = pageSize)
        }.onSuccess {
            response = LoadingResponse.Success(it.hits.map { ResultMap.mapResultToImage(it) })
        }.onFailure {
            response = LoadingResponse.Error(it.message.toString())
        }

        return response
    }
}