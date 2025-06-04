package com.example.firstappkmp

import com.example.firstappkmp.article.ArticleLocalDataSource
import com.example.firstappkmp.article.ArticleRepository
import com.example.firstappkmp.article.ArticleService
import com.example.firstappkmp.article.ArticleViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

    private val networkModule = module {
        single {
            HttpClient {
                install(ContentNegotiation) {
                    json(Json {
                        ignoreUnknownKeys = true
                    })
                }
            }
        }
    }
    private val articleModule = module {
        single { ArticleLocalDataSource(get()) }
        single { ArticleService(get()) }
        single { ArticleRepository(get(), get()) }
        single { ArticleViewModel(get()) }
    }
    val sharedKoinModule = listOf(
        articleModule,
        networkModule
    )
