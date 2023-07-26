package com.example.newsapp.localdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapp.model.Article

const val ARTICLES_TABLE_NAME = "articles"

@Entity(ARTICLES_TABLE_NAME)
data class ArticleEntity(
    val author: String?,
    @PrimaryKey val title: String,
    val description: String?,
    val url: String,
)

fun ArticleEntity.mapToArticleDomain(): Article {
    return Article(this.author, this.title, this.description, this.url)
}

fun List<ArticleEntity>.mapToArticleDomain(): List<Article> {
    return this.map {
        it.mapToArticleDomain()
    }
}


