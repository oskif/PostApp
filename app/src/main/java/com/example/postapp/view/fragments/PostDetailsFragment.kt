package com.example.postapp.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.postapp.R
import com.example.postapp.databinding.FragmentPostDetailsBinding
import com.example.postapp.presenters.contracts.PostDetailsContract
import com.example.postapp.repository.models.Post
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PostDetailsFragment : Fragment(R.layout.fragment_post_details), PostDetailsContract.View {
    private var binding: FragmentPostDetailsBinding? = null
    private val arg by navArgs<PostDetailsFragmentArgs>()

    @Inject
    lateinit var presenter: PostDetailsContract.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostDetailsBinding.bind(view)
        presenter.initialize(this)
        presenter.getPostDetails(arg.postId)
    }

    override fun showPostDetail(post: Post) {
        binding?.tvBody?.text = post.body
        binding?.tvTitle?.text = post.title
    }
}