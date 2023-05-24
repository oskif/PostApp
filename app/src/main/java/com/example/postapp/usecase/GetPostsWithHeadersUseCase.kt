package com.example.postapp.usecase

import com.example.postapp.presenters.models.PostListItem
import com.example.postapp.repository.PostsRepository
import io.reactivex.Single
import javax.inject.Inject

interface GetPostsWithHeadersUseCase {
    fun execute(): Single<List<PostListItem>>
}

class GetPostsWithHeadersUseCaseImpl @Inject constructor(
    private val postsRepository: PostsRepository
) : GetPostsWithHeadersUseCase {

    override fun execute(): Single<List<PostListItem>> =
        postsRepository.getGroupedPostsByTitle().map {
            val postsHeaders = mutableListOf<PostListItem>()
            for (item in it) {
                postsHeaders.add(PostListItem.Header(item.key.uppercaseChar()))
                postsHeaders.addAll(item.value.map { PostListItem.Item(it) })
            }
            postsHeaders
        }
}