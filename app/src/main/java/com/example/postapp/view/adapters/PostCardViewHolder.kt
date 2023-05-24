package com.example.postsapp.cards

import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.databinding.CardCellBinding
import com.example.postapp.repository.models.Post

class PostCardViewHolder(
    private val binding: CardCellBinding,
    onItemClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }

    fun postBind(item: Post) {
        binding.title.text = item.title
        binding.body.text = item.body
    }
}