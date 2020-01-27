package com.fandu.data.repository

import com.fandu.data.model.CustomModel

// sent to CustomModel -> sebelum nya costumEntity
// tembak from CustomRepository

interface BaseRepository {

    fun insert(customModel: CustomModel)

    fun update(customModel: CustomModel)

    fun delete(customModel: CustomModel)

    fun deleteAll()

}