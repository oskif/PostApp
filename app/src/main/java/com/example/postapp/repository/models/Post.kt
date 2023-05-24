package com.example.postapp.repository.models

data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val userId: Int
)