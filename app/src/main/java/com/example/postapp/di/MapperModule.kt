package com.example.postapp.di

import com.example.postapp.mappers.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostServiceMapperModule {
    @Provides
    @Singleton
    fun providePostDatabaseToRepositoryPostMapper(): PostDatabaseToRepositoryPostMapper =
        PostDatabaseToRepositoryPostMapperImpl()

    @Provides
    @Singleton
    fun providePostServiceToRepositoryPostMapper(): PostServiceToRepositoryPostMapper =
        PostServiceToRepositoryPostMapperImpl()

    @Provides
    @Singleton
    fun providePostToInsertToDatabasePostMapper(): PostToInsertToDatabasePostMapper =
        PostToInsertToDatabasePostMapperImpl()

    @Provides
    @Singleton
    fun providePostToInsertToServicePostMapper(): PostToInsertToServicePostMapper =
        PostToInsertToServicePostMapperImpl()
}
