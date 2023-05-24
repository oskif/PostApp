package com.example.postapp.di

import android.content.Context
import androidx.room.Room
import com.example.postapp.database.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providePostDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        PostDatabase::class.java,
        "post_database"
    ).build()

    @Singleton
    @Provides
    fun provide(postDatabase: PostDatabase) = postDatabase.postDao()

}