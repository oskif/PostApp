package com.example.postapp.di

import com.example.postapp.repository.PostsRepository
import com.example.postapp.usecase.GetPostsWithHeadersUseCase
import com.example.postapp.usecase.GetPostsWithHeadersUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostsWithHeadersUseCase {
    @Provides
    @Singleton
    fun provideGetPostsWithHeadersUseCases(
        postsRepository: PostsRepository
    ): GetPostsWithHeadersUseCase =
        GetPostsWithHeadersUseCaseImpl(postsRepository)
}