package com.paweloot.ui

import com.paweloot.base.BaseViewModel
import com.paweloot.network.PostApi
import javax.inject.Inject

class PostListViewModel : BaseViewModel() {

    @Inject
    lateinit var postApi: PostApi


}