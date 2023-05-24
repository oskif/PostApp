package com.example.postapp.presenters.models

import com.example.postapp.repository.models.Post

sealed class PostListItem  {
    data class Header(val letter: Char) : PostListItem()
    data class Item(val post: Post) : PostListItem()
}