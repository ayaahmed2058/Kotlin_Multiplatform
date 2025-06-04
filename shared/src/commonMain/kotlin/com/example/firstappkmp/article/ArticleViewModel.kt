package com.example.firstappkmp.article

import com.example.firstappkmp.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(
    private var articleRepository: ArticleRepository
) : BaseViewModel() {

    private var _articles: MutableStateFlow<ArticleState> =
        MutableStateFlow(ArticleState(isLoading = true))
    val articles = _articles.asStateFlow()

    fun getArticles() {
        scope.launch {
            val result = articleRepository.getArticles()
            delay(2000)
            _articles.emit(ArticleState(error = "Something Wrong Happened!!"))
            delay(2000)
            _articles.emit(ArticleState(articles = result))
        }
    }

    private fun insertArticles(articles: List<ArticleModel>) {
        scope.launch {
            articleRepository.insertArticles(articles)
        }
    }
}