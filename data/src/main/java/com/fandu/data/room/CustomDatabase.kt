package com.fandu.data.room

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.fandu.data.room.CustomEntity
import com.fandu.data.room.CustomDAO

// send to CustomEntity
// send to CustomDAO
// tembak from CustomRepository

@Database(
    entities = [CustomEntity::class],
    version = 1 //increment when database updated
)

abstract class CustomDatabase : RoomDatabase() {

    abstract fun customDao() : CustomDAO

    companion object {
        @Volatile private var instance : CustomDatabase? = null

        fun getInstance(context: Context) : CustomDatabase? {
            if (instance == null) {
                synchronized(CustomDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CustomDatabase::class.java, "custom_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback : RoomDatabase.Callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db) // First Creation of database
                Log.d("fandu", "First Creation of database")
                PopulateDbAsyncTask(instance).execute()
            }
        }

        class PopulateDbAsyncTask(db : CustomDatabase?) : AsyncTask<Unit, Unit, Unit>() {
//            private val customDAO = db?.customDao()

            override fun doInBackground(vararg params: Unit) {
//                customDAO?.insert(CustomEntity("name 0"))
//                customDAO?.insert(CustomEntity("name 1"))
//                customDAO?.insert(CustomEntity("name 2"))
//                customDAO?.insert(CustomEntity("name 3"))
//                customDAO?.insert(CustomEntity("name 4"))

            }
        }

    }
}