package com.example.newsapp.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.model.Article
import com.example.retrofitguide.R

@Composable
fun NewsCard(article: Article) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = article.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = article.description ?: stringResource(R.string.no_description),
                fontSize = 14.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                text = "- ${article.author ?: stringResource(R.string.anonimous)}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Right
            )
        }
    }
}

@Preview
@Composable
fun NewsCardPrev() {
    Surface {
        NewsCard(article = Article("Ferdinand", "This is the title", "This is the descriptions", "URL"))
    }
}