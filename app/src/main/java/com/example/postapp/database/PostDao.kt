package com.example.postapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postapp.database.model.Post
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPost(post: Post): Completable

    @Query("SELECT * FROM post_table")
    fun readAllPosts(): Single<List<Post>>

    @Query("SELECT * FROM post_table WHERE id =:postId")
    fun getPost(postId: Int): Single<Post>
}