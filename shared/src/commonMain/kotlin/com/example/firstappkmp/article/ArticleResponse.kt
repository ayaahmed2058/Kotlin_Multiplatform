package com.example.firstappkmp.article

import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    var status: String?,
    var totalResults: Int?,
    var articles: List<ArticleModel>?
)