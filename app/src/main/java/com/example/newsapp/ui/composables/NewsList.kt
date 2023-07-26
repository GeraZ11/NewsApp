package com.example.newsapp.ui.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.model.Article

@Composable
fun NewsList(list: List<Article>) {
    LazyColumn(content = {
        items(list) {
            NewsCard(article = it)
        }
    })
}

@Preview
@Composable
fun NewsListPrev() {

}