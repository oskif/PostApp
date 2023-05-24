package com.example.postapp.mappers

import com.example.postapp.repository.models.Post
import com.example.postapp.service.models.Post as ServicePost

interface PostServiceToRepositoryPostMapper : Mapper<ServicePost, Post>

class PostServiceToRepositoryPostMapperImpl : PostServiceToRepositoryPostMapper {
    override fun map(input: ServicePost): Post =
        Post(
            id = input.id,
            title = input.title,
            body = input.body,
            userId = input.userId
        )
}