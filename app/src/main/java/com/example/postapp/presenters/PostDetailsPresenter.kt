package com.example.postapp.presenters

import android.util.Log
import com.example.postapp.presenters.contracts.PostDetailsContract
import com.example.postapp.repository.PostsRepository
import com.example.postapp.repository.models.Post
import com.example.postapp.service.PostService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostDetailsPresenter @Inject constructor(
    private val postService: PostService,
    private val postRepository: PostsRepository
) : PostDetailsContract.Presenter {
    private lateinit var view: PostDetailsContract.View
    private val compositeDisposable = CompositeDisposable()

    override fun getPostDetails(postId: Int) {
        compositeDisposable.add(
            postRepository.getPostByIdFromDatabase(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setPostDetail)
        )
    }

    private fun setPostDetail(post: Post) =
        view.showPostDetail(post)

    override fun initialize(view: PostDetailsContract.View) {
        this.view = view
    }

    override fun onDestroy() = compositeDisposable.dispose()
}