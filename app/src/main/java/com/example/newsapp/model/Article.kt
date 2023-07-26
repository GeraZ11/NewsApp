package com.example.newsapp.model

import com.example.newsapp.localdb.entities.ArticleEntity

data class Article(
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
)

fun Article.toArticleEntity() : ArticleEntity = ArticleEntity(this.author, this.title, this.description, this.url)
