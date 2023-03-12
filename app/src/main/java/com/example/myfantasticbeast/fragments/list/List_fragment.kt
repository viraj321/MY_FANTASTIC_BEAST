package com.example.myfantasticbeast.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfantasticbeast.R
import com.example.myfantasticbeast.data.animal
import com.example.myfantasticbeast.data.animalviewmodel
import kotlinx.android.synthetic.main.fragment_list_fragment.view.*

class list_fragment : Fragment() {
    private lateinit var animalviewmodel: animalviewmodel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_fragment, container, false)

        val adapter = ListAdapter()

        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        animalviewmodel = ViewModelProvider(this).get(animalviewmodel::class.java)
        animalviewmodel.readAllData.observe(viewLifecycleOwner, Observer { animal ->
            adapter.setData(animal)
        })

        view.floatingActionButton.setOnClickListener(){
            findNavController().navigate(R.id.action_list_fragment_to_add_fragment)
        }

        setHasOptionsMenu(true)
    return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.menu.delete_menu){
            deleteallanimals()

        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteallanimals() {

        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_->
            animalviewmodel.deleteallanimals(animal(0, location = "ccv", taxonomy = "cv", characterstic = "cv"))
            Toast.makeText(requireContext(),"successfully removed"
                , Toast.LENGTH_SHORT).show()




        }
        builder.setNegativeButton("No") {_, _->

            builder.setTitle("delete?")
            builder.setMessage("are you sure")
            builder.create().show()
    }
}}