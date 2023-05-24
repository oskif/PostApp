package com.example.postapp.mappers

import com.example.postapp.repository.models.Post
import com.example.postapp.database.model.Post as DatabasePost

interface PostDatabaseToRepositoryPostMapper : Mapper<DatabasePost, Post>

class PostDatabaseToRepositoryPostMapperImpl : PostDatabaseToRepositoryPostMapper {
    override fun map(input: DatabasePost): Post =
        Post(
            id = input.id,
            title = input.title,
            body = input.body,
            userId = input.userId
        )
}