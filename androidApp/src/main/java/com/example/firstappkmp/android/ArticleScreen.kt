package com.example.firstappkmp.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.firstappkmp.article.ArticleViewModel

@Composable
fun ArticleScreen(modifier: Modifier = Modifier, articleViewModel: ArticleViewModel) {


    LaunchedEffect(Unit) {
        articleViewModel.getArticles()

    }
    val articles = articleViewModel.articles.collectAsState().value



    LazyColumn(
        Modifier.fillMaxSize().padding(end = 16.dp, start = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {



        if (articles.isLoading) {

            item {
                CircularProgressIndicator(
                    color = Color.Black
                )

            }
        } else if (articles.error != null) {

            item {
                Text(text = articles.error ?: "")
            }
        } else {
            item {
                Spacer(modifier = Modifier.height(60.dp))
                Text("Articles", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            }

            items(articles.articles.size) {
                Spacer(modifier = Modifier.height(45.dp))
                AsyncImage(model = articles.articles[it].urlToImage, contentDescription = "")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = articles.articles[it].title ?: "", style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = articles.articles[it].description ?: "")
                Spacer(modifier = Modifier.height(8.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                Text(text = articles.articles[it].publishedAt ?: "", textAlign = TextAlign.End, style = TextStyle(color = Color.LightGray))
                }
                Spacer(modifier = Modifier.height(8.dp))


            }


        }


    }


}