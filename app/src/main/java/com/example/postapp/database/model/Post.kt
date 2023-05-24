package com.example.postapp.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_table")
data class Post(
    val title: String,
    val body: String,
    val userId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
