package com.fandu.home.view

import com.fandu.data.model.CustomModel

// note fandu
// tembak from BaseViewHolder
// tembak from CustomAdapter
// tembak from MainFragment
// tembak from CostumViewHolder

// send to CustomModel

interface CustomListeners {

    fun onUpdate(item : CustomModel, position: Int)

    fun onDelete(item : CustomModel, position: Int)

}