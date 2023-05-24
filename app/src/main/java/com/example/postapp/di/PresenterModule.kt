package com.example.postapp.di

import com.example.postapp.presenters.PostAddPresenter
import com.example.postapp.presenters.PostDetailsPresenter
import com.example.postapp.presenters.PostListPresenter
import com.example.postapp.presenters.contracts.PostAddContract
import com.example.postapp.presenters.contracts.PostDetailsContract
import com.example.postapp.presenters.contracts.PostListContract
import com.example.postapp.repository.PostsRepository
import com.example.postapp.service.PostService
import com.example.postapp.usecase.GetPostsWithHeadersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object PostAddPresenter {
    @Provides
    fun providePostAddPresenter(
        postRepository: PostsRepository
    ): PostAddContract.Presenter =
        PostAddPresenter(postRepository)
}

@Module
@InstallIn(ActivityComponent::class)
object PostListPresenterModule {
    @Provides
    fun providePostListPresenter(
        getPostsWithHeadersUseCase: GetPostsWithHeadersUseCase
    ): PostListContract.Presenter =
        PostListPresenter(getPostsWithHeadersUseCase)
}

@Module
@InstallIn(ActivityComponent::class)
object PostDetailsPresenterModule {
    @Provides
    fun providePostDetailsPresenter(
        postService: PostService,
        postRepository: PostsRepository
    ): PostDetailsContract.Presenter =
        PostDetailsPresenter(postService, postRepository)
}
