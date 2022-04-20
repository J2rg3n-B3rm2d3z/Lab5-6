package com.laboratorios.lab56.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.laboratorios.lab56.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding use to set View in the screen

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    //Function to button when click in Login

    fun onClickArteLista (view: View){
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

    //Function to button to switch a createAccount Activity

    fun onClickCrearCuenta(view: View) {
        val intent = Intent(this, CreateAccountActivity::class.java)
        startActivity(intent)
    }

}