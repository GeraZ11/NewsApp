package com.example.newsapp.repositories.news

import com.example.newsapp.localdb.dao.ArticlesDao
import com.example.newsapp.model.Article
import com.example.newsapp.model.toArticleEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface NewsRepositoryInterface {
    suspend fun reloadNews()
    fun getAllNewsStream(): Flow<List<Article>>
}

class NewsRepository @Inject constructor(
    private val newsLocalDatasource: NewsLocalDatasource,
    private val newsNetworkDataSource: NewsNetworkDataSource,
    private val dao: ArticlesDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) : NewsRepositoryInterface {
    override suspend fun reloadNews() = withContext(dispatcher) {
        newsNetworkDataSource.getArticlesStream()
            .catch { }
            .collect {
                it.forEach {
                    dao.saveArticle(it.toArticleEntity())
                }
            }
    }

    override fun getAllNewsStream(): Flow<List<Article>>  {
        return newsLocalDatasource.getArticlesStream()
    }
}