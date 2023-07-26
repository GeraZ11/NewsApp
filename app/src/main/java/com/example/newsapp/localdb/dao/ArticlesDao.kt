package com.example.newsapp.localdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.localdb.entities.ARTICLES_TABLE_NAME
import com.example.newsapp.localdb.entities.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticlesDao {
    @Query("SELECT * FROM $ARTICLES_TABLE_NAME")
    fun getArticlesStream(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveArticle(article: ArticleEntity)
}