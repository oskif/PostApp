package com.example.postapp.view.widgets

import android.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import com.example.postapp.R

class ProgressBar() {
    private lateinit var alertDialog: AlertDialog
    fun startProgressBar(activity: FragmentActivity?) {
        val inflater = activity?.layoutInflater
        val dialogView = inflater?.inflate(R.layout.progres_bar, null)

        val builder = AlertDialog.Builder(activity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        alertDialog = builder.create()
        alertDialog.show()
    }

    fun dialogDismiss() {
        alertDialog.dismiss()
    }
}