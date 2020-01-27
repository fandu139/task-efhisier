package com.fandu.data.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.fandu.data.model.CustomModel
import com.fandu.data.room.CustomDAO
import com.fandu.data.repository.BaseRepository
import com.fandu.data.repository.ConvertList
import com.fandu.data.room.CustomDatabase
import com.fandu.data.room.CustomEntity

// sent to BaseRepository
// sent to CustomDAO
// sent to CustomDatabase
// sent to CustomModel
// sent to CustomEntity
// sent to ConvertList

// tembak from MainViewModel

class CustomRepository(applicationContext: Application) : BaseRepository {

    private lateinit var customDao: CustomDAO

    companion object {
        @Volatile private var INSTANCE : CustomRepository? = null

        fun getInstance(applicationContext : Application) : CustomRepository {
            return INSTANCE ?: CustomRepository(applicationContext)
        }
    }

    init {
        val database = CustomDatabase.getInstance(applicationContext.applicationContext)
        customDao = database!!.customDao()
    }

    //region CRUD Operation
    override fun insert(customModel: CustomModel) { // change CustomEntity to CustomModel
        AsyncTask.execute {
            customDao.insert(
                ConvertList.toEntity(customModel = customModel)
            )
        }
    }

    override fun update(customModel: CustomModel) { // change CustomEntity to CustomModel
        //customDao.update(customEntity)
        AsyncTask.execute {
            customDao.update(
                ConvertList.toEntity(customModel)
            )
        }
    }

    override fun delete(customModel: CustomModel) { // change CustomEntity to CustomModel
        println("${customModel.id}")
        AsyncTask.execute {
            customDao.delete(
                customModel.id
            )
        }
    }

    override fun deleteAll() {
        AsyncTask.execute {
            customDao.deleteAll()
        }
    }

    fun getAll() : LiveData<MutableList<CustomModel>> {
        return ConvertList.toLiveDataListModel(
            customDao.getAll()
        )
    }

    // end region

    private fun convertList(customEntity: List<CustomEntity>) : MutableList<CustomModel> {
        val itemList = mutableListOf<CustomModel>()
        customEntity.map { itemList.add(CustomModel(it.id?:0, it.subtitle?:"",it.description?:"", it.url?:"")) }

        return itemList
    }

}