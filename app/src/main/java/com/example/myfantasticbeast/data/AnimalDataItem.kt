package com.example.myfantasticbeast.data

import androidx.room.PrimaryKey

data class AnimalDataItem(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val locations: String,
    val taxonomy: String,
    val name: String

)
