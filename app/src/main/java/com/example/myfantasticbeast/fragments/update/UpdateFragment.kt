package com.example.myfantasticbeast.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myfantasticbeast.R
import com.example.myfantasticbeast.data.animal
import com.example.myfantasticbeast.data.Animalviewmodel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private lateinit var animalviewmodel: Animalviewmodel

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
        setHasOptionsMenu(true)


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



}

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deleteanimal()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteanimal() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_->
            animalviewmodel.deleteanimal(args.currentanimal)
            Toast.makeText(requireContext(),"successfully removed: ${args.currentanimal.taxonomy}"
                ,Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_list_fragment)



        }
        builder.setNegativeButton("No") {_, _->

            builder.setTitle("delete ${args.currentanimal.taxonomy}?")
            builder.setMessage("are you sure")
            builder.create().show()
        }
        }
    }
