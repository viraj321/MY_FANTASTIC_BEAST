package com.example.myfantasticbeast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myfantasticbeast.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView3.setOnClickListener{val intent = Intent(this, SignUpActivity::class.java)

            startActivity(intent)}
        binding.login2.setOnClickListener{
            val email = binding.editText8.text.toString()
        val password = binding.editText7.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {



                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }

                    else{
                        Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()
                    }}}


        else{
            Toast.makeText(this, "fill everything" , Toast.LENGTH_SHORT).show()

        }
    }
}}