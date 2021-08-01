package ru.maxdexter.mywallpaper.data.remote.model

data class Result(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)