package com.example.postapp.mappers

import com.example.postapp.repository.models.PostToInsert
import com.example.postapp.service.models.ServicePostToInsert

interface PostToInsertToServicePostMapper : Mapper<PostToInsert, ServicePostToInsert>

class PostToInsertToServicePostMapperImpl : PostToInsertToServicePostMapper {
    override fun map(input: PostToInsert): ServicePostToInsert =
        ServicePostToInsert(
            title = input.title,
            body = input.body,
            userId = input.userId
        )

}