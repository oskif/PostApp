package com.example.postapp.presenters

import com.example.postapp.presenters.contracts.PostListContract
import com.example.postapp.presenters.models.PostListItem
import com.example.postapp.usecase.GetPostsWithHeadersUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

class PostListPresenter @Inject constructor(
    getPostsWithHeadersUseCase: GetPostsWithHeadersUseCase
) : PostListContract.Presenter {
    private val compositeDisposable = CompositeDisposable()
    private lateinit var view: PostListContract.View

    init {
        compositeDisposable.add(
            getPostsWithHeadersUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setPosts)
        )
    }

    override fun onDestroy() = compositeDisposable.dispose()

    override fun initialize(view: PostListContract.View) {
        this.view = view
    }

    private fun setPosts(items: List<PostListItem>) =
        view.showPosts(items)
}