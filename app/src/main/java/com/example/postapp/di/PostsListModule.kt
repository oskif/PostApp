package com.example.postapp.di

import com.example.postapp.presenters.contracts.PostListContract
import com.example.postapp.view.fragments.PostsListFragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class PostListModule {
    @Binds
    abstract fun providesPostListView(activity: PostsListFragment): PostListContract.View
}