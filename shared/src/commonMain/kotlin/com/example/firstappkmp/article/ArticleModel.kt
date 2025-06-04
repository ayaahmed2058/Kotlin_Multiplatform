package com.example.firstappkmp.article

import kotlinx.serialization.Serializable

@Serializable
data class ArticleModel(
    val title: String?,
    val description: String?,
    val publishedAt: String?,
    val urlToImage: String?
)


