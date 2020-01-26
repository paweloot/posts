package com.paweloot.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.paweloot.posts.R
import com.paweloot.posts.databinding.FragmentPostListBinding

class PostListFragment : Fragment() {

    private lateinit var binding: FragmentPostListBinding
    private lateinit var viewModel: PostListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding =
            FragmentPostListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(PostListViewModel::class.java)

        binding.viewModel = viewModel
        binding.postList.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}