package com.example.postapp.presenters.contracts

import com.example.postapp.repository.models.PostToInsert

object PostAddContract {
    interface View {
        fun onDataSaved()
        fun showValidateFailToast()
        fun startProgressBar()
        fun stopProgressBar()
        fun showErrorAlert()
    }

    interface Presenter {
        fun initialize(view: View)
        fun saveData(post: PostToInsert)
        fun onDestroy()
    }
}
