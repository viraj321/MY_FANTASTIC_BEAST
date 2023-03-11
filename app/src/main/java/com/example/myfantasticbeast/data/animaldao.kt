package com.example.myfantasticbeast.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface animaldao {
    @Insert(onConflict= OnConflictStrategy.IGNORE )
    suspend fun addanimal(animal: animal)

    @Update
    suspend fun updateanimal(animal: animal)

    @Query("SELECT * FROM animal_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<animal>>
}