package com.example.postapp.presenters

import android.util.Log
import com.example.postapp.presenters.contracts.PostAddContract
import com.example.postapp.repository.PostsRepository
import com.example.postapp.repository.models.PostToInsert
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostAddPresenter @Inject constructor(
    private val postRepository: PostsRepository,
) : PostAddContract.Presenter {
    private lateinit var view: PostAddContract.View
    private val compositeDisposable = CompositeDisposable()

    override fun initialize(view: PostAddContract.View) {
        this.view = view
    }

    override fun saveData(post: PostToInsert) {
        if (post.title != "" && post.body != "") {
            compositeDisposable.add(
                postRepository.addPost(post)
                    .doOnError {
                        view.stopProgressBar()
                        view.showErrorAlert()
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ view.onDataSaved() }, { Log.e("Error", "${it.message}") })
            )
            view.startProgressBar()
        } else view.showValidateFailToast()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}