package com.paweloot.base

import androidx.lifecycle.ViewModel
import com.paweloot.di.component.DaggerViewModelInjector
import com.paweloot.di.component.ViewModelInjector
import com.paweloot.di.module.NetworkModule
import com.paweloot.ui.PostListViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}