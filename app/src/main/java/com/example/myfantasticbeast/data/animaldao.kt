package com.example.myfantasticbeast.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import java.util.concurrent.Flow

@Dao
interface animaldao {
    @Insert(onConflict= OnConflictStrategy.IGNORE )
    suspend fun addanimal(animal: animal)

    @Update
    suspend fun updateanimal(animal: animal)

    @Delete
    suspend fun deleteanimal(animal: animal)

    @Query("DELETE FROM animal_table")
    suspend fun deleteallanimals()


    @Query("SELECT * FROM animal_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<animal>>


}