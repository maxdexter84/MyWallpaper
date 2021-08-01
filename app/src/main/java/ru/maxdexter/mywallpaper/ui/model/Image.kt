package ru.maxdexter.mywallpaper.ui.model

data class Image(
    val id: Int,
    val largeImageURL: String,
    val pageURL: String,
    val previewURL: String,
    val tags: String,
    val type: String,
    val webformatURL: String,
)
