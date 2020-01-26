package com.paweloot.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paweloot.base.BaseViewModel
import com.paweloot.model.Post

class PostViewModel : BaseViewModel() {

    private val _postTitle = MutableLiveData<String>()
    private val _postBody = MutableLiveData<String>()

    val postTitle: LiveData<String>
        get() = _postTitle
    val postBody: LiveData<String>
        get() = _postBody

    fun bind(post: Post) {
        _postTitle.value = post.title
        _postBody.value = post.body
    }
}