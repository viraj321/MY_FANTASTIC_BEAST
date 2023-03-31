package com.example.myfantasticbeast

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.volley.Header
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myfantasticbeast.data.Animalviewmodel
import com.example.myfantasticbeast.data.Animalviewmodelfactory
import com.example.myfantasticbeast.data.animal
import com.example.myfantasticbeast.data.animaldatabase
import kotlinx.android.synthetic.main.custom_row.*
import kotlinx.android.synthetic.main.fragment_list_fragment.*
import org.json.JSONObject
import org.json.JSONStringer


class MainActivity : AppCompatActivity() {
    var animalList = arrayListOf<animal>()

  //  val apiSample = "https://api.api-ninjas.com/v1/cats?name={}"
    //val jsonobj = JSONObject()

//    lateinit var animalviewmodel: Animalviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //val queue = Volley.newRequestQueue(this)




  //  val Request = JsonObjectRequest(Request.Method.GET,apiSample,jsonobj,{res ->
//Log.d("volley sample",res.toString())
        //val jsonArray = res.getJSONArray("data")
        //Log.d("volley sample",res.toString())
        //for (i in 0..jsonArray.length() ){
            //val jsonObj = jsonArray.getJSONObject(i)
          //  Log.d("volley sample",jsonObj.toString())

        //    val animal = animal(jsonObj.getInt("id"),
      //      jsonObj.getString("location"),
    //        jsonObj.getString("taxonomy"),
  //          jsonObj.getString("name"))


//animalList.add(animal)
        //    Log.d("volley sample",animalList.toString())

      //  }

    //}, {err->
      //  Log.d("volley sample failed",err.message.toString())


   // })

// Add the request to the RequestQueue.
  //  queue.add(Request)





        setContentView(R.layout.activity_main)
  // //  supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color))

//        animalviewmodel = ViewModelProviders.of(this,Animalviewmodelfactory(this)).get(Animalviewmodel::class.java)

        val navHost=supportFragmentManager.findFragmentById(R.id.fragmentContainerView)

        setupActionBarWithNavController(navHost!!.findNavController())

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp()  || return super.onSupportNavigateUp()
    }
}
