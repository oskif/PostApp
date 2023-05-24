package com.example.postapp.di

import com.example.postapp.presenters.contracts.PostAddContract
import com.example.postapp.view.fragments.PostAddFragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class PostAddModule {
    @Binds
    abstract fun providesPostAddView(activity: PostAddFragment): PostAddContract.View
}