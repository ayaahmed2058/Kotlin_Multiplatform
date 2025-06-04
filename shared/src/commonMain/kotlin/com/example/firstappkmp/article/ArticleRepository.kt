package com.example.firstappkmp.article

class ArticleRepository(
    private val articleService: ArticleService,
    private val localDataSource: ArticleLocalDataSource
) {

    suspend fun getArticles(): List<ArticleModel> {
        val localArticles = localDataSource.getAllArticles()
        if (localArticles.isNotEmpty()) {
            return localArticles
        }
        insertArticles(articleService.getArticles())
        return articleService.getArticles()
    }

    fun insertArticles(articles: List<ArticleModel>) {
        localDataSource.insertAllArticles(articles)
    }


}