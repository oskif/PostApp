package com.example.postapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.postapp.database.model.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}