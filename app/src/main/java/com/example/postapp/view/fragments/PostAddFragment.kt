package com.example.postapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import com.example.postapp.R
import com.example.postapp.databinding.FragmentPostAddBinding
import com.example.postapp.presenters.contracts.PostAddContract
import com.example.postapp.repository.models.PostToInsert
import com.example.postapp.view.widgets.ProgressBar
import com.example.postapp.view.widgets.ServerErrorDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PostAddFragment : Fragment(R.layout.fragment_post_add), PostAddContract.View {
    private var fragmentBinding: FragmentPostAddBinding? = null

    @Inject
    lateinit var presenter: PostAddContract.Presenter

    private val progressBar = ProgressBar()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPostAddBinding.bind(view)
        fragmentBinding = binding
        presenter.initialize(this)

        binding.btnAdd.setOnClickListener {
            ViewCompat.getWindowInsetsController(requireView())?.hide(WindowInsetsCompat.Type.ime())
            val title = binding.insertTitle.text.toString()
            val body = binding.insertBody.text.toString()
            presenter.saveData(PostToInsert(title, body, 0))
        }
    }

    override fun onDataSaved() {
        progressBar.dialogDismiss()
        findNavController().navigate(PostAddFragmentDirections.navigateToPostsListFragment())
    }

    override fun showValidateFailToast() =
        Toast.makeText(activity, "Title and body cannot be empty", Toast.LENGTH_SHORT).show()

    override fun startProgressBar() {
        progressBar.startProgressBar(activity)
    }

    override fun stopProgressBar() =
        progressBar.dialogDismiss()

    override fun showErrorAlert() =
        ServerErrorDialogFragment().show(childFragmentManager, ServerErrorDialogFragment.TAG)
}
