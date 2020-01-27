package com.fandu.data.model

import com.fandu.data.R

// baru fandu
// tembak from CustomModel
// tembak from ConvertList
// tembak from BaseRepository
// tembak from BaseViewHolder

// note fandu :
// tembak dari CostumListener
// tembak dari CustomViewHolder
// tembak dari CustomAdapter
// tembak dari MainViewModel
// tembak dari xml data ui item_simple
// tembak dari mainFragment

// tembak dari CustomRepository

class CustomModel {

    var id: Int? = null
    var name: String? = null

    var icon: Int? = null

    var subtitle: String? = null
    var description: String? = null
    var url: String? = null

    constructor(name: String) {
        this.name = name
        this.icon = R.drawable.ic_launcher_foreground
    }

    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
        this.icon = R.drawable.ic_launcher_foreground
    }

    constructor(id: Int, name: String, icon : Int) {
        this.id = id
        this.name = name
        this.icon = icon
    }

    constructor(subtitle: String, description: String, url: String) {
        this.subtitle = subtitle
        this.description = description
        this.url = url
    }

    constructor(id: Int, subtitle: String, description: String, url: String) {
        this.id = id
        this.subtitle = subtitle
        this.description = description
        this.url = url
    }
}