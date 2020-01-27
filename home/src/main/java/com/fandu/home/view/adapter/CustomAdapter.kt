package com.fandu.home.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fandu.home.R
import com.fandu.home.databinding.CustomBinder
import com.fandu.data.model.CustomModel
import com.fandu.home.view.CustomListeners
import com.fandu.home.view.holder.CustomViewHolder

// note fandu
// send to CustomViewHolder
// send to CustomListeners
// send to view xml item_sample
// send to databinding xml (item_simlpe) CustomBinder and send to databinding CustomBinder.customModel
// send to mutableList CustomModel
// tembak from MainFragment

class CustomAdapter : RecyclerView.Adapter<CustomViewHolder> {

    /**Main */
    private lateinit var context : Context
    private lateinit var customListeners : CustomListeners

    private lateinit var customBinder : CustomBinder

    private var list : MutableList<CustomModel>  = mutableListOf()

    constructor(context : Context, customListeners : CustomListeners) : super() {
        this.context = context
        this.customListeners = customListeners
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        customBinder = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_sample,
            parent,
            false
        )
        return CustomViewHolder(context, customListeners, customBinder)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        customBinder.customModel = list.get(position)
        holder.bindDataToViewHolder(list[position],position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setItems(items : List<CustomModel>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }
}