package com.paweloot.utils

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentFragment: Fragment = view.findFragment()

    visibility?.observe(parentFragment, Observer { value ->
        view.visibility = value ?: View.VISIBLE
    })
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: LiveData<String>?) {
    val parentFragment: Fragment = view.findFragment()

    text?.observe(parentFragment, Observer { value ->
        view.text = value ?: ""
    })
}

@BindingAdapter("adapter")
fun setListAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}