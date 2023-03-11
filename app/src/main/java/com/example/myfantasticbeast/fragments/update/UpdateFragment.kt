package com.example.myfantasticbeast.fragments.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myfantasticbeast.R
import com.example.myfantasticbeast.data.animal
import com.example.myfantasticbeast.data.animalviewmodel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private lateinit var animalviewmodel: animalviewmodel

    private val args by navArgs<UpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        animalviewmodel = ViewModelProvider(this).get(animalviewmodel::class.java)


        view.updateLocation_et.setText(args.currentanimal.location)
        view.updateTaxonomy_et.setText(args.currentanimal.taxonomy)
        view.updateCharacterstic_et.setText(args.currentanimal.characterstic)

        view.update_btn.setOnClickListener{
            updateItem()
        }


        return view
    }

    private fun updateItem(){
        val location = updateLocation_et.text.toString()
        val taxonomy = updateTaxonomy_et.text.toString()
        val characterstic = updateCharacterstic_et.text.toString()

        if (inputCheck(location, taxonomy, characterstic)){
            val updatedanimal = animal(args.currentanimal.id, location, taxonomy, characterstic)

            animalviewmodel.updateanimal(updatedanimal)

            Toast.makeText(requireContext(),"successfully updated",Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragment_to_list_fragment)
        }else{
            Toast.makeText(requireContext(),"fill carefully",Toast.LENGTH_SHORT).show()
        }


    }

    private fun inputCheck(location:String, taxonomy:String, characterstics:String): Boolean{
        return !TextUtils.isEmpty(location) && !TextUtils.isEmpty(taxonomy) && !TextUtils.isEmpty(characterstics)

}}