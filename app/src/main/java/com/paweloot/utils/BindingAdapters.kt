package com.paweloot.utils

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentFragment: Fragment = view.findFragment()

    visibility?.observe(parentFragment, Observer { value ->
        view.visibility = value ?: View.VISIBLE
    })
}