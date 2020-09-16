package com.example.mvvmtraining.utils

import android.content.Context
import android.provider.SyncStateContract
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvvmtraining.data.Constants


fun Context.setImageView(view: ImageView, url:String){
        Glide.with(this)
            .load("${Constants.IMAGE_URL}${url}.png")
            .into(view)
    }
