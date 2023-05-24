package com.example.postapp.presenters.contracts

import com.example.postapp.repository.models.Post

object PostDetailsContract {
    interface View {
        fun showPostDetail(post: Post)
    }

    interface Presenter {
        fun getPostDetails(postId: Int)
        fun initialize(view: View)
        fun onDestroy()
    }
}