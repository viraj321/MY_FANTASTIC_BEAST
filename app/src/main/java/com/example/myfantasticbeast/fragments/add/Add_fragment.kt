package com.example.myfantasticbeast.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myfantasticbeast.R
import com.example.myfantasticbeast.data.animal
import com.example.myfantasticbeast.data.animalviewmodel
import kotlinx.android.synthetic.main.fragment_add_fragment.*
import kotlinx.android.synthetic.main.fragment_add_fragment.view.*

class add_fragment : Fragment() {
    private lateinit var manimalviewmodel: animalviewmodel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_fragment, container, false)
        manimalviewmodel = ViewModelProvider(this).get(animalviewmodel::class.java)

        view.button2.setOnClickListener{
            insertDataToDatabase()
        }
        return view


        }

    private fun insertDataToDatabase() {
        val location = addLocation_et.text.toString()
        val taxonomy = addTaxonomy_et.text.toString()
        val characterstic = addCharacterstic_et.text.toString()

        if(inputCheck(location,taxonomy,characterstic)){
            val animal = animal(0,location, taxonomy, characterstic)
            manimalviewmodel.addanimal(animal)
            Toast.makeText(requireContext(),"added successfully",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_add_fragment_to_list_fragment)
        }else{
            Toast.makeText(requireContext(),"fill properly",Toast.LENGTH_LONG).show()
        }

    }
    private fun inputCheck(location:String, taxonomy:String, characterstics:String): Boolean{
        return !TextUtils.isEmpty(location) && !TextUtils.isEmpty(taxonomy) && !TextUtils.isEmpty(characterstics)

    }


}


