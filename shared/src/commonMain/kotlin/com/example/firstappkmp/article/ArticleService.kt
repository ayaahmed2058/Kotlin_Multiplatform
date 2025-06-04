package com.example.firstappkmp.article

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient: HttpClient) {
    private val apiKey = "29d6de43574e4caba2404d20aec66488"
    private val baseUrl = "https://newsapi.org/v2"
    private val category = "business"
    private val country = "us"

    suspend fun getArticles(): List<ArticleModel> {
        val response =
            httpClient.get("$baseUrl/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body<ArticleResponse>()

        return response.articles ?: listOf()
    }
}