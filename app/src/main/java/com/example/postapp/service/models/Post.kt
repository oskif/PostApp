package com.example.postapp.service.models

data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val userId: Int
)