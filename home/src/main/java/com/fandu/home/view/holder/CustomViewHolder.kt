package com.fandu.home.view.holder

import android.content.Context
import android.view.View
import com.fandu.home.databinding.CustomBinder
import com.fandu.data.model.CustomModel
import com.fandu.home.view.CustomListeners

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
        //customBinder.imageView.setBackgroundResource(item.icon?:0)
        customBinder.imageView.setImageResource(item.icon?:0)
        customBinder.buttonEdit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view : View) {
                getListener().onUpdate(item,position)
            }
        })
        customBinder.buttonDelete.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view : View) {
                getListener().onDelete(item,position)
            }
        })
    }

}