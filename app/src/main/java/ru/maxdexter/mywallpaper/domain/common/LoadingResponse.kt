package ru.maxdexter.mywallpaper.domain.common

import ru.maxdexter.mywallpaper.ui.model.Image


sealed class LoadingResponse{
    class Success(val data: List<Image>) : LoadingResponse()
    class Error(val message: String) : LoadingResponse()
    object Loading : LoadingResponse()
}