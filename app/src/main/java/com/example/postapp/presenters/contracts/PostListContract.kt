package com.example.postapp.presenters.contracts

import com.example.postapp.presenters.models.PostListItem

object PostListContract {
    interface View {
        fun showPosts(posts: List<PostListItem>)
    }

    interface Presenter {
        fun onDestroy()
        fun initialize(view: View)
    }
}