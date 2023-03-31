package com.example.myfantasticbeast.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "animal_table")
 data class animal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

     val location: String,
     val taxonomy: String,
     val characterstic: String



 ): Parcelable
