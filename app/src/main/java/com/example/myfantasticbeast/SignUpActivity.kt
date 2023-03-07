package com.example.myfantasticbeast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myfantasticbeast.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.textView2.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)

            startActivity(intent)}
        binding.signupbutton.setOnClickListener {

            val email = binding.editText3.text.toString()
            val fullname = binding.editText.text.toString()
            val password = binding.editText2.text.toString()

            if (email.isNotEmpty() && fullname.isNotEmpty()) {
                if(password.isNotEmpty()){


                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, SignInActivity::class.java)
                        startActivity(intent)
                    }

                else{
                    Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()
                }}}
            else {
                Toast.makeText(this, "fill password properly", Toast.LENGTH_SHORT).show()
            }
        }else{Toast.makeText(this, "fill everything" , Toast.LENGTH_SHORT).show()

    }}


}}
