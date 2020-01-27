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

    fun insertItem(item: CustomModel) {
        customRepository.insert(item)
    }

    fun getItems() : LiveData<MutableList<CustomModel>> {
        return customRepository.getAll()
    }
}