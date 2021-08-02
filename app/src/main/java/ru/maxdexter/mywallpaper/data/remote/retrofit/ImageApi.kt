package ru.maxdexter.mywallpaper.data.remote.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import ru.maxdexter.mywallpaper.data.remote.model.Result

interface ImageApi {

    @GET("api/?key=22732329-7132ef4352db940989ab33af1&orientation=vertical")
    suspend fun getImages(
        @Query("category") category: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): Result
}