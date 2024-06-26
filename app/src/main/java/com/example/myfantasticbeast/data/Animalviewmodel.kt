package com.example.myfantasticbeast.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Animalviewmodel(context: Context): ViewModel() {

    val readAllData: LiveData<List<animal>>
    private val repository: animalrepository


    init {
        val animaldao = animaldatabase.getDatabase(context).animaldao()
        repository = animalrepository(animaldao)
        readAllData = repository.readAllData
    }
    fun addanimal(animal: animal){
        viewModelScope.launch(Dispatchers.IO){
            repository.addanimal(animal)
        }
    }

    fun updateanimal(animal: animal){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateanimal(animal)
        }
    }

    fun deleteanimal(animal: animal){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteanimal(animal)
        }
    }

    fun deleteallanimals(animal: animal){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteallanimals()
        }
    }



}