package com.example.newsapp.repositories.news

import com.example.newsapp.api.NewsClient
import com.example.newsapp.api.responses.mapToArticleDomain
import com.example.newsapp.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsNetworkDataSource @Inject constructor(
    private val service: NewsClient
) {
    fun getArticlesStream(): Flow<List<Article>> = flow {
        val response = service.getHeadlines()
        try {
            if (response.status == "ok") {
                emit(response.articles.mapToArticleDomain())
            } else {
                emit(emptyList())
            }
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}