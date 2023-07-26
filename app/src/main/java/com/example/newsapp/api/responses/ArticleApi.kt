package com.example.newsapp.api.responses

import com.example.newsapp.model.Article


data class ArticleApi(
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
)

fun ArticleApi.mapToArticleDomain(): com.example.newsapp.model.Article {
    return Article(this.author, this.title, this.description, this.url)
}


fun List<ArticleApi>.mapToArticleDomain(): List<Article> {
    return this.map {
        it.mapToArticleDomain()
    }
}
