package com.example.firstappkmp.article

data class ArticleState(
    var isLoading: Boolean = false,
    var articles: List<ArticleModel> = emptyList(),
    var error: String? = null

)