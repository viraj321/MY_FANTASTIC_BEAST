package com.example.myfantasticbeast.fragments.list

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.Volley
import com.example.myfantasticbeast.R
import com.example.myfantasticbeast.data.*
import kotlinx.android.synthetic.main.custom_row.*
import kotlinx.android.synthetic.main.fragment_list_fragment.view.*
import java.util.*

class list_fragment : Fragment() {
   lateinit var animalList : AnimalData

    val adapter = ListAdapter()


    private lateinit var animalviewmodel: Animalviewmodel
    val apiSample:String = "https://api.api-ninjas.com/v1/animals?name=cheetah"
    //val jsonobj = JSONObject()

 //   private lateinit var searchView: SearchView





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       // val SearchView = view.searchView

        //val queue = Volley.newRequestQueue(context)



       // val Request = JsonObjectRequest(Request.Method.GET,apiSample,null,{ res ->
         //   Log.d("volley sample",res.toString())
           // val jsonArray = res.getJSONArray("data")
            //Log.d("volley sample",res.toString())
            //for (i in 0..jsonArray.length() ){
              //  val jsonObj = jsonArray.getJSONObject(i)
                //Log.d("volley sample",jsonObj.toString())

//                val animal = animal(jsonObj.getInt("id"),
  //                  jsonObj.getString("location"),
    //                jsonObj.getString("taxonomy"),
      //              jsonObj.getString("name"))

        //        animalList.add(animal)
          //      Log.d("volley sample",animalList.toString())

            //}

       // }, {err->
         //   Log.d("volley sample failed",err.message.toString())


      //  })
//        {@Throws(AuthFailureError::class)
//            @Override
//            override fun getHeaders() : Map<String>, String> {
//                val headers = HashMap<String, String>()
//            headers["x-api-key"] = "7bZoiRBJ4Coo50hdNuRiQw==j8hnr2WehzWxFksX"
//        }


     //   }
       // queue.add(Request)



        val view = inflater.inflate(R.layout.fragment_list_fragment, container, false)

        val adapter = ListAdapter()

        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

       //  val searchView = view.searchView

       // searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
         //   override fun onQueryTextSubmit(query: String?): Boolean {
           //     return false
            //}

            //override fun onQueryTextChange(newText: String?): Boolean {
              //  filterList(newText)
               // return true

           // }

        //})





        animalviewmodel = ViewModelProviders.of(this,Animalviewmodelfactory(view.context)).get(Animalviewmodel::class.java)
        animalviewmodel.readAllData.observe(viewLifecycleOwner, Observer { animal ->
            adapter.setData(animal)
        })

        view.floatingActionButton.setOnClickListener(){
            findNavController().navigate(R.id.action_list_fragment_to_add_fragment)
        }

        setHasOptionsMenu(true)
        getAnimal()
    return view
    }
   // private fun filterList(query : String?){
     //   if (query!=null){
       //     val filteredList = ArrayList<animal>()
         //   for (i in animalList){
           //     if (i.characteristics.lowercase(Locale.ROOT).contains((query)){
             //       filteredList.add(i)
               // }
            //}if (filteredList.isEmpty()) {
              //  Toast.makeText(this, "no data found", Toast.LENGTH_SHORT).show()
            //}
            //}

        //}
    //}

    @SuppressLint("data changed")
    private fun getAnimal(){
        val Queue: RequestQueue =  Volley.newRequestQueue(context)
        val Request = object :JsonArrayRequest(Request.Method.GET,apiSample,null,
            Response.Listener {
                val name = it.getJSONObject(0).getString("name")
                val taxonomy = it.getJSONObject(0).getJSONObject("taxonomy")
               // val kingdom = it.getJSONObject(0).getJSONObject("kingdom")
              Toast.makeText(context,taxonomy.get("kingdom").toString(),Toast.LENGTH_LONG).show()
                val kingdom = taxonomy.get("kingdom").toString()
                val location = it.getJSONObject(0).getString("locations")
                val characteristics = it.getJSONObject(0).getJSONObject("characteristics")
                val diet = characteristics.get("diet").toString()
                var individualAnimal = AnimalDataItem(id,location,kingdom,name)

               // animalList.add(individualAnimal)

               // try {
                 //   for (i in 0 until it.length()) {
                   //     val respObj = it.getJSONObject(i.toString())
                     //   Log.d("Response", it.toString());
                       // val location = respObj.getString("location")
                        //val name = respObj.getString("name")
                        //val Characterstics = respObj.getString("Characterstics")
                        //val taxonomy = respObj.getString("taxonomy")
                        //var individualanimal =
                          //  AnimalDataItem(Characterstics, location, name, taxonomy)
                        //animalList.add(individualanimal)
                        //Log.d("VolleyData", location.toString())
                        //Log.d("VolleyData", Characterstics.toString())
                        //Log.d("VolleyData", taxonomy.toString())
                        //Log.d("VolleyData", taxonomy.toString())

                    //}
               // }

                  //  catch(e:java. lang . Exception){
                    //    Log.d("java.lang.Exception", e.toString())
                      //  e.printStackTrace()

             //   }
            },Response.ErrorListener {
                Log.d("VollyError",it.toString())
            }){

               override fun getHeaders():MutableMap<String,String> {
                   var headers = HashMap<String, String>()
                   headers.put("x-api-key","7bZoiRBJ4Coo50hdNuRiQw==j8hnr2WehzWxFksX")
                   return headers
                   return super.getHeaders()
               }

           override fun getParams(): MutableMap<String, String>? {
               var params  = HashMap<String,String>()
                headers.put("name" ,"lion")
                return params
               return super.getParams()
            }
            }

        Queue.add(Request)
        val recyclerView = view?.recyclerview
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())


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
            animalviewmodel.deleteallanimals(animal( id, "cheetah","jnj","bhbhn"))
            Toast.makeText(requireContext(),"successfully removed"
                , Toast.LENGTH_SHORT).show()




        }
        builder.setNegativeButton("No") {_, _->

            builder.setTitle("delete?")
            builder.setMessage("are you sure")
            builder.create().show()
    }
}}