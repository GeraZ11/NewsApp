package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.localdb.NewsDatabase
import com.example.newsapp.localdb.dao.ArticlesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsDatabaseModule {

    @Provides
    fun provideArticlesDao(database: NewsDatabase): ArticlesDao {
        return database.articlesDao()
    }

    @Singleton
    @Provides
    fun provideNewsDatabase(@ApplicationContext appContext: Context) : NewsDatabase {
        return NewsDatabase.buildNewsDB(appContext)
    }
}