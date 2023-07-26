package com.example.newsapp.di

import com.example.newsapp.api.NewsClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NewsClientModule {
    @Singleton
    @Provides
    fun provideNewsClient(): NewsClient {
        return  Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsClient::class.java)
    }
}