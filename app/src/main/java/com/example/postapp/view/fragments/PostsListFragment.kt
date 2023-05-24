package com.example.postapp.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.R
import com.example.postapp.databinding.FragmentPostsListBinding
import com.example.postapp.presenters.contracts.PostListContract
import com.example.postapp.presenters.models.PostListItem
import com.example.postapp.view.adapters.CardAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PostsListFragment() : PostListContract.View, Fragment(R.layout.fragment_posts_list) {
    private var fragmentBinding: FragmentPostsListBinding? = null

    @Inject
    lateinit var presenter: PostListContract.Presenter

    private val adapter = CardAdapter() { post ->
        findNavController().navigate(PostsListFragmentDirections.navigateToDetailsFragment(post.post.id))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPostsListBinding.bind(view)
        fragmentBinding = binding

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(PostsListFragmentDirections.navigateToAddFragment())
        }

        binding.mainRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = this@PostsListFragment.adapter
        }
        presenter.initialize(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

    override fun showPosts(posts: List<PostListItem>) {
        adapter.setItems(posts)
    }
}