package com.example.postapp.mappers

import com.example.postapp.database.model.Post
import com.example.postapp.repository.models.PostToInsert

interface PostToInsertToDatabasePostMapper : Mapper<PostToInsert, Post>

class PostToInsertToDatabasePostMapperImpl : PostToInsertToDatabasePostMapper {
    override fun map(input: PostToInsert): Post =
        Post(
            title = input.title,
            body = input.body,
            userId = input.userId
        )
}