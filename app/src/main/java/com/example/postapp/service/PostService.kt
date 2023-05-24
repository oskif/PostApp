package com.example.postapp.service

import com.example.postapp.service.models.Post
import com.example.postapp.service.models.ServicePostToInsert
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostService {
    @GET("posts")
    fun getPosts(): Single<List<Post>>

    @GET("posts/{id}")
    fun getPostById(@Path("id") postId: Int): Single<Post>

    @POST("/posts")
    fun addPostToApi(@Body post: ServicePostToInsert): Single<Response<Post>>
}