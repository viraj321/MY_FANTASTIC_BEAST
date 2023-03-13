package com.example.myfantasticbeast.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [animal::class], version = 1, exportSchema = false)
abstract class animaldatabase : RoomDatabase(){
    abstract fun animaldao(): animaldao

    companion object{
        @Volatile
        private var INSTANCE: animaldatabase? = null

        fun getDatabase(context: Context): animaldatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance

            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    animaldatabase::class.java,
                    "animal_database"
                ).build()
                INSTANCE = instance
                return instance

            }

        }

    }
}
