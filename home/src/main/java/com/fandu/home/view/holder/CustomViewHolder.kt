package com.fandu.home.view.holder

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fandu.home.databinding.CustomBinder
import com.fandu.data.model.CustomModel
import com.fandu.home.view.CustomListeners
import android.R
import android.graphics.Bitmap
import android.util.Log
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bumptech.glide.request.target.BitmapImageViewTarget


// note fandu
// send to databinding xml CustomBinder view item_simple
// send to CustomListeners in constructor
// send to BaseViewHolder in bindDataToViewHolder
// sent to CustomModel

// tembak from CustomAdapter

class CustomViewHolder : BaseViewHolder {

    private lateinit var customBinder : CustomBinder

    constructor(context: Context, customListeners: CustomListeners, customBinder : CustomBinder) : super(context, customListeners, customBinder.root) {
        this.customBinder = customBinder
    }

    override fun bindDataToViewHolder(item: CustomModel, position: Int) {
        setId(item.id?:0)

        Glide.with(itemView.context)
            .load(item.url)
            .into(customBinder.imageView)
    }

}