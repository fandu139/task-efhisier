package com.fandu.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fandu.data.repository.CustomRepository
import com.fandu.data.model.CustomModel

// note fandu
// send to CustomModel
// tembak from xml ui main_fragment
// tembak from add_fragment
// tembak from MainFragment
// tembak dari MainActivity

// send to CustomRepository

class MainViewModel : AndroidViewModel {

    private lateinit var customRepository: CustomRepository
    private lateinit var liveList: MutableLiveData<MutableList<CustomModel>>
    private lateinit var liveUpdate: MutableLiveData<CustomModel> // baru

    constructor(application: Application) : super(application) {
        customRepository = CustomRepository.getInstance(application)
        liveList = MutableLiveData()
        liveUpdate = MutableLiveData() // baru
    }

    fun setItems() {
//        val itemList = mutableListOf<CustomModel>()
//        itemList.clear()
//        itemList.add(CustomModel(0, "name 0"))
//        itemList.add(CustomModel(1, "name 1"))
//        itemList.add(CustomModel(2, "name 2"))
//        itemList.add(CustomModel(3, "name 3"))
//        itemList.add(CustomModel(4, "name 4"))
//        itemList.add(CustomModel(5, "name 5"))
//        itemList.add(CustomModel(6, "name 6"))
//        itemList.add(CustomModel(7, "name 7"))
//        itemList.add(CustomModel(8, "name 8"))
//        liveList.value = itemList
    }

    fun setUpdate(item: CustomModel) { // baru
        liveUpdate.value = item
    }

    fun getUpdate() : LiveData<CustomModel> { // baru
        return liveUpdate
    }

    fun insertItem(item: CustomModel) {
        customRepository.insert(item)
    }

    fun getItems() : LiveData<MutableList<CustomModel>> {
        return customRepository.getAll()
    }
}