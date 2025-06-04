package com.example.firstappkmp.article

import sqldelight.articles.db.ArticlesDatabase

class ArticleLocalDataSource(
    private val database: ArticlesDatabase
) {

    fun getAllArticles(): List<ArticleModel> {
        return database.articleQueries.selectAllArticles(::mapToArticle).executeAsList()
    }

    fun insertAllArticles(articles: List<ArticleModel>) {

        database.articleQueries.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }

    }

    private fun insertArticle(article: ArticleModel) {
        database.articleQueries.insertArticle(
            title = article.title ?: "",
            desc = article.description,
            date = article.publishedAt ?: "",
            imgUrl = article.urlToImage
        )
    }

    private fun mapToArticle(
        title: String,
        desc: String?,
        date: String,
        imgUrl: String?
    ): ArticleModel {
        return ArticleModel(
            title = title,
            description = desc,
            publishedAt = date,
            urlToImage = imgUrl
        )
    }


}