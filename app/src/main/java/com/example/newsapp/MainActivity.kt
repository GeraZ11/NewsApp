package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.ui.screens.MainScreen
import com.example.newsapp.ui.theme.RetrofitGuideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitGuideTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    RetrofitGuideTheme {
        MainScreen()
    }
}