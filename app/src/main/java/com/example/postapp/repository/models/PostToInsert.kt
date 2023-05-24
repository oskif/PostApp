package com.example.postapp.repository.models

data class PostToInsert(
    val title: String,
    val body: String,
    val userId: Int
)