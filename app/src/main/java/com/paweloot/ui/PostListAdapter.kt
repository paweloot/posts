package com.paweloot.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paweloot.model.Post
import com.paweloot.posts.databinding.ListItemPostBinding

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.PostHolder>() {

    private var postList: List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding =
            ListItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount() = postList.size

    fun updatePostList(postList: List<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    inner class PostHolder(private val binding: ListItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val viewModel = PostViewModel()

        fun bind(post: Post) {
            viewModel.bind(post)
            binding.viewModel = viewModel
        }
    }
}