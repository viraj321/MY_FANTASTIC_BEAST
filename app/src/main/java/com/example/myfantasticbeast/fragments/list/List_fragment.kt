package com.example.myfantasticbeast.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfantasticbeast.R
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
    return view
    }


}