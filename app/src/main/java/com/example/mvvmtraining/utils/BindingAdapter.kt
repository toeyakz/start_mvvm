package com.example.mvvmtraining.utils

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["visibleGone"], requireAll = false)
    fun showHide(view: View, visibleGone: Boolean) {
        view.visibility = if (visibleGone) View.VISIBLE else View.GONE
    }
}