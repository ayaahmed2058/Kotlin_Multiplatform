package com.example.firstappkmp.android

import app.cash.sqldelight.db.SqlDriver
import com.example.firstappkmp.DatabaseDriverFactory
import com.example.firstappkmp.article.ArticleViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sqldelight.articles.db.ArticlesDatabase

val viewModelModule = module {
    viewModel { ArticleViewModel(get()) }
}

val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory(androidContext()).createDriver()
    }

    single<ArticlesDatabase> { ArticlesDatabase(get()) }
}

