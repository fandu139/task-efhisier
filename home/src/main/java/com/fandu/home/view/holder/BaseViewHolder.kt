package com.fandu.home.view.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fandu.data.model.CustomModel
import com.fandu.home.view.CustomListeners

// note fandu
// send to CustomListeners
// terget from CustomViewHolder
// sent to CustomModel

abstract class BaseViewHolder : RecyclerView.ViewHolder {

    /**Main */
    private lateinit var context : Context
    private lateinit var customListeners : CustomListeners
    /**Data */
    private var id : Int? = null

    constructor(context: Context, customListeners: CustomListeners, view : View) : super(view) {
        this.context = context
        this.customListeners = customListeners
    }

    fun setId(id : Int) {
        this.id
    }

    fun getId() : Int{
        return id?:0
    }

    fun getContext() : Context {
        return context
    }

    fun getListener() : CustomListeners {
        return customListeners
    }

    abstract fun bindDataToViewHolder(item : CustomModel, position : Int)
}