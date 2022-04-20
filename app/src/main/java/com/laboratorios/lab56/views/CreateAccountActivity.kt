package com.laboratorios.lab56.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.laboratorios.lab56.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Set view on screen

        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Setup the Toolbar

        val toolbar: Toolbar = binding.toolbarCrearCuenta
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Crear Cuenta"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //Event to get a button

        binding.btnCrearCuenta.setOnClickListener {
            Toast.makeText(this, "El usuario ha sido creado", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}
