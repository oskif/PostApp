package com.example.postapp.view.widgets

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ServerErrorDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("Server error, try again later.")
            .setPositiveButton("Ok") { _, _ -> }
            .create()

    companion object {
        const val TAG = "Server error"
    }
}