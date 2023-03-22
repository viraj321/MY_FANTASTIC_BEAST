package com.example.myfantasticbeast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myfantasticbeast.data.Animalviewmodel
import com.example.myfantasticbeast.data.Animalviewmodelfactory
import com.example.myfantasticbeast.data.animal
import com.example.myfantasticbeast.data.animaldatabase


class MainActivity : AppCompatActivity() {

//    lateinit var animalviewmodel: Animalviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        animalviewmodel = ViewModelProviders.of(this,Animalviewmodelfactory(this)).get(Animalviewmodel::class.java)

        val navHost=supportFragmentManager.findFragmentById(R.id.fragmentContainerView)

        setupActionBarWithNavController(navHost!!.findNavController())

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp()  || return super.onSupportNavigateUp()
    }
}
