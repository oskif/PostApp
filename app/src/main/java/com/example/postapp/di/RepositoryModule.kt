package com.example.postapp.di

import com.example.postapp.database.PostDao
import com.example.postapp.mappers.*
import com.example.postapp.repository.PostsRepository
import com.example.postapp.repository.PostsRepositoryImpl
import com.example.postapp.service.PostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providePostRepository(
        postService: PostService,
        postDao: PostDao,
        postDatabaseToRepositoryPostMapper: PostDatabaseToRepositoryPostMapper,
        postToInsertToDatabasePostMapper: PostToInsertToDatabasePostMapper,
        postToInsertToServicePostMapper: PostToInsertToServicePostMapper,
        postServiceToRepositoryPostMapper : PostServiceToRepositoryPostMapper

    ): PostsRepository =
        PostsRepositoryImpl(
            postService,
            postDao,
            postDatabaseToRepositoryPostMapper,
            postToInsertToDatabasePostMapper,
            postToInsertToServicePostMapper,
            postServiceToRepositoryPostMapper
        )
}