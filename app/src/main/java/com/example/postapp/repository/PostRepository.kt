package com.example.postapp.repository

import com.example.postapp.database.PostDao
import com.example.postapp.mappers.*
import com.example.postapp.service.PostService
import com.example.postapp.repository.models.Post
import com.example.postapp.repository.models.PostToInsert
import io.reactivex.Completable
import io.reactivex.Single

import javax.inject.Inject

interface PostsRepository {
    fun getGroupedPostsByTitle(): Single<Map<Char, List<Post>>>
    fun getPosts(): Single<List<Post>>
    fun addPostToDatabase(post: PostToInsert): Completable
    fun getPostByIdFromDatabase(postID: Int): Single<Post>
    fun addPostToApi(post: PostToInsert): Single<Post>
    fun addPost(post: PostToInsert): Completable
}

class PostsRepositoryImpl @Inject constructor(
    private val postService: PostService,
    private val postDao: PostDao,
    private val postDatabaseToRepositoryPostMapper: PostDatabaseToRepositoryPostMapper,
    private val postToInsertToDatabasePostMapper: PostToInsertToDatabasePostMapper,
    private val postToInsertToServicePostMapper: PostToInsertToServicePostMapper,
    private val postServiceToRepositoryPostMapper: PostServiceToRepositoryPostMapper
) : PostsRepository {
    override fun getPosts(): Single<List<Post>> =
        postDao.readAllPosts().map {
            it.map { item ->
                postDatabaseToRepositoryPostMapper.map(item)
            }
        }

    override fun addPostToDatabase(post: PostToInsert): Completable =
        postDao.addPost(postToInsertToDatabasePostMapper.map(post))

    override fun addPostToApi(post: PostToInsert): Single<Post> =
        postService.addPostToApi(postToInsertToServicePostMapper.map(post)).flatMap { item ->
            if (item.isSuccessful) {
                item.body()?.let { post ->
                    Single.just(postServiceToRepositoryPostMapper.map(post))
                } ?: Single.error(Exception("Empty body"))
            } else {
                Single.error(Exception("Error during uploading post ${item.code()}"))
            }
        }

    override fun getPostByIdFromDatabase(postID: Int): Single<Post> =
        postDao.getPost(postID).map { item ->
            postDatabaseToRepositoryPostMapper.map(item)
        }

    override fun addPost(post: PostToInsert): Completable =
        addPostToApi(post).flatMapCompletable {
            addPostToDatabase(post)
        }

    override fun getGroupedPostsByTitle(): Single<Map<Char, List<Post>>> =
        getPosts().map {
            it.groupBy {
                it.title.first().uppercaseChar()
            }.toSortedMap()
        }
}