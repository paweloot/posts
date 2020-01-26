package com.paweloot.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.paweloot.di.ViewModelFactory
import com.paweloot.posts.R
import com.paweloot.posts.databinding.FragmentPostListBinding

class PostListFragment : Fragment() {

    private lateinit var binding: FragmentPostListBinding
    private lateinit var viewModel: PostListViewModel

    private var errorSnackbar: Snackbar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPostListBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, ViewModelFactory(requireActivity() as AppCompatActivity))
                .get(PostListViewModel::class.java)

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { errorMessage ->
            if (errorMessage != null)
                showErrorSnackbar(errorMessage)
            else
                hideErrorSnackbar()
        })

        binding.viewModel = viewModel
        binding.postList.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    private fun showErrorSnackbar(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideErrorSnackbar() {
        errorSnackbar?.dismiss()
    }
}