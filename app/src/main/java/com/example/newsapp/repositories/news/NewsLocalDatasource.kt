package com.example.newsapp.repositories.news

import com.example.newsapp.localdb.dao.ArticlesDao
import com.example.newsapp.localdb.entities.mapToArticleDomain
import com.example.newsapp.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsLocalDatasource @Inject constructor(
    private val articlesDao: ArticlesDao
) {
    fun getArticlesStream(): Flow<List<Article>> = articlesDao.getArticlesStream().map { it.mapToArticleDomain() }
}