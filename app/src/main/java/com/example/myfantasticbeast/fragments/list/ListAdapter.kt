package com.example.myfantasticbeast.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myfantasticbeast.R
import com.example.myfantasticbeast.data.animal
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var animalList = emptyList<animal>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = animalList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.location_txt.text = currentItem.location
        holder.itemView.taxonomy_txt.text = currentItem.taxonomy
        holder.itemView.characterstic_txt.text = currentItem.characterstic

        holder.itemView.rowLayout.setOnClickListener{
            val action = list_fragmentDirections.actionListFragmentToUpdateFragment(currentItem)
           holder.itemView.findNavController().navigate(action)


        }
    }

    override fun getItemCount(): Int {
       return animalList.size
    }

    fun setData(animal: List<animal>){
        this.animalList = animal
        notifyDataSetChanged()
    }
    interface  onClick{

    }
}