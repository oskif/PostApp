package com.example.postapp.view.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.databinding.HeaderCellBinding
import com.example.postapp.presenters.models.PostListItem

class HeaderCardViewHolder(private val binding: HeaderCellBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun headerBind(header: PostListItem.Header) {
        binding.header.text = header.letter.toString()
    }
}