package com.example.newsapp.api

import com.example.newsapp.NEWS_API_KEY
import com.example.newsapp.api.responses.NewsResponse
import retrofit2.http.GET

interface NewsClient {
    @GET("https://newsapi.org/v2/top-headlines?country=us&apiKey=${NEWS_API_KEY}")
    suspend fun getHeadlines(): NewsResponse
}