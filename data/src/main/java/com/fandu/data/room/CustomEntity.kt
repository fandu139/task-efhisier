package com.fandu.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// baru
// tembak from ConvertList

// tembak from CustomDAO
// tembak from CustomDatabase
// tembak from BaseRepository -> hapus
// tembak from CustomRepository

@Entity(tableName = "custom_table")
data class CustomEntity (

//    @ColumnInfo(name = "Name")
//    var name : String? = null,
//
//    @ColumnInfo(name = "Icon")
//    var icon : Int? = null

//    description
//    url

    @ColumnInfo(name = "Subtitle")
    var subtitle : String? = null,

    @ColumnInfo(name = "Description")
    var description : String? = null,

    @ColumnInfo(name = "URL")
    var url : String? = null

){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id : Int? = null

    constructor(id : Int, subtitle : String, description: String, url: String) : this() {
        this.id = id
        this.subtitle = subtitle
        this.description = description
        this.url = url
    }
}