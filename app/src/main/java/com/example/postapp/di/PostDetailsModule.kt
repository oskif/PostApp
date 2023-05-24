package com.example.postapp.di

import com.example.postapp.presenters.contracts.PostDetailsContract
import com.example.postapp.view.fragments.PostDetailsFragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class PostDetailsModule {
    @Binds
    abstract fun providesPostDetailsView(activity: PostDetailsFragment): PostDetailsContract.View
}