package com.fandu.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.fandu.data.model.CustomModel
import com.fandu.data.room.CustomEntity

// baru
// sent to customEntity
// sent to CustomModel
// tembak from CustomRepository

class ConvertList {

    companion object {
        private fun toListModel(customEntity: List<CustomEntity>) : MutableList<CustomModel> {
            val itemList : MutableList<CustomModel> = mutableListOf<CustomModel>()
            customEntity.map {
                itemList.add(
                    CustomModel(it.id?:0, it.subtitle?:"", it.description?:"", it.url?:"")
                )
            }
            return itemList
        }

        fun toLiveDataListModel(localList: LiveData<List<CustomEntity>>) : LiveData<MutableList<CustomModel>> {
            return Transformations.map<
                    List<CustomEntity>, //localList Data Type
                    MutableList<CustomModel> //toListModel List Data Type
                    >(
                localList,
                ::toListModel
            )
        }

        fun toEntity(customModel: CustomModel) : CustomEntity {
            return  when(customModel.id){
                null -> {
                    CustomEntity(
                        customModel.subtitle?:"",
                        customModel.description?:"",
                        customModel.url?:""
                    )
                } else -> {
                    CustomEntity(
                        customModel.id!!,
                        customModel.subtitle?:"",
                        customModel.description?:"",
                        customModel.url?:""
                    )
                }
            }
        }

    }

}