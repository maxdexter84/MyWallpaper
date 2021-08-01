package ru.maxdexter.mywallpaper.data.remote.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    //https://pixabay.com/api/?key=22732329-7132ef4352db940989ab33af1&q=yellow+flowers&image_type=photo
    @GET("/api/")
    suspend fun getCategories(
        @Query("key") key: String = "22732329-7132ef4352db940989ab33af1&",
        @Query("category") category: String
    )
}