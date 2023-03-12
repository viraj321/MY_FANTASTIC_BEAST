package com.example.myfantasticbeast.data

import androidx.lifecycle.LiveData

class animalrepository ( private val animaldao: animaldao){
    val readAllData: LiveData<List<animal>> = animaldao.readAllData()
    suspend fun addanimal(animal: animal){
        animaldao.addanimal(animal)
    }

    suspend fun updateanimal(animal: animal){
        animaldao.updateanimal(animal)
    }

    suspend fun deleteanimal(animal: animal){
        animaldao.deleteanimal(animal)
    }

    suspend fun deleteallanimals(){
        animaldao.deleteallanimals()
    }
}
