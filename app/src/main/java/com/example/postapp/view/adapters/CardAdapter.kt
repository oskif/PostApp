package com.example.postapp.view.adapters

import com.example.postapp.presenters.models.PostListItem
import com.example.postsapp.cards.PostCardViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.databinding.CardCellBinding
import com.example.postapp.databinding.HeaderCellBinding

private enum class ViewType {
    HEADER,
    POST
}

class CardAdapter(
    var onItemClicked: ((PostListItem.Item) -> Unit)? = null
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(

) {
    private var items = mutableListOf<PostListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.HEADER.ordinal -> {
                val binding =
                    HeaderCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                HeaderCardViewHolder(binding)
            }

            ViewType.POST.ordinal -> {
                val binding =
                    CardCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PostCardViewHolder(binding) {
                    onItemClicked?.invoke(items[it] as PostListItem.Item)
                }
            }

            else -> error("Invalid view type!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostCardViewHolder -> holder.postBind((items[position] as PostListItem.Item).post)
            is HeaderCardViewHolder -> holder.headerBind(items[position] as PostListItem.Header)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int =
        when (items[position]) {
            is PostListItem.Header -> ViewType.HEADER.ordinal
            is PostListItem.Item -> ViewType.POST.ordinal
        }

    fun setItems(posts: List<PostListItem>) {
        items.clear()
        items.addAll(posts)
        notifyDataSetChanged()
    }
}