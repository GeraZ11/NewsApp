package com.example.newsapp.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapp.localdb.dao.ArticlesDao
import com.example.newsapp.localdb.entities.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun articlesDao(): ArticlesDao

    companion object {
        fun buildNewsDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NewsDatabase::class.java,
                "news.db"
            ).build()

    }

}

