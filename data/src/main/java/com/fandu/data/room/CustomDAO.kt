package com.fandu.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fandu.data.room.CustomEntity

// send to CustomEntity
// tembak from CustomDatabase
// tembak from CustomRepository

@Dao
interface CustomDAO {

    @Insert
    fun insert(customEntity: CustomEntity)

    @Update
    fun update(customEntity: CustomEntity)

//    @Delete
//    fun delete(customEntity: CustomEntity)

    @Query("DELETE FROM custom_table WHERE Id = :id")
    fun delete(id : Int?)

    @Query(value = "DELETE FROM custom_table")
    fun deleteAll()

    @Query(value = "SELECT * FROM custom_table")
    fun getAll() : LiveData<List<CustomEntity>>

}