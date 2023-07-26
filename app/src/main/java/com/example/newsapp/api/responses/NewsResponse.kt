package com.example.newsapp.api.responses

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleApi>
)
