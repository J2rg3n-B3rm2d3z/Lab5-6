package com.laboratorios.lab56.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
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

        emailFocusListener()
        passswordFocusListener()
        passwordConfirmFocusListener()

        binding.btnCrearCuenta.setOnClickListener {

            val userText = binding.tvEmailCuenta.text.toString()
            val passwordText = binding.tvPasswordCuenta.text.toString()
            val passwordTextConfirmar = binding.tvConfirmarPassword.text.toString()

            if(Patterns.EMAIL_ADDRESS.matcher(userText).matches() && passwordText.length >= 3 &&
                passwordText.length <= 8 &&
                (passwordText.matches(".*[a-z].*".toRegex()) ||
                        passwordText.matches(".*[A-Z].*".toRegex())) &&
                passwordText.matches(".*[0-9].*".toRegex()) &&
                passwordText == passwordTextConfirmar) {

                Toast.makeText(this, "El usuario ha sido creado", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

    }

    private fun emailFocusListener() {
        binding.tvEmailCuenta.setOnFocusChangeListener { _, focused ->
            if(!focused)
                binding.tvEmailCuentaContainer.helperText = validEmail()
        }
    }

    private fun validEmail(): String? {
        val userText = binding.tvEmailCuenta.text.toString()

        return if(!Patterns.EMAIL_ADDRESS.matcher(userText).matches())
            "E-mail invalido"
        else if(userText=="")
            "Requerido"
        else
            null
    }



    private fun passswordFocusListener() {
        binding.tvPasswordCuenta.setOnFocusChangeListener { _, focused ->
            if(!focused)
                binding.tvPasswordCuentaContainer.helperText = validpasssword()
        }
    }

    private fun validpasssword(): String? {
        val passwordText = binding.tvPasswordCuenta.text.toString()

        return if(passwordText.length<3)
            "Minimo 3 caracteres"
        else if(passwordText.length>8)
            "Maximo 8 caracteres"
        else if(!passwordText.matches(".*[a-z].*".toRegex()) &&
            !passwordText.matches(".*[A-Z].*".toRegex()))
            "Debe tener letras"
        else if(!passwordText.matches(".*[0-9].*".toRegex()))
            "Debe tener digitos"
        else if(passwordText=="")
            "Requerido"
        else
            null
    }


    private fun passwordConfirmFocusListener() {
        binding.tvConfirmarPassword.setOnFocusChangeListener { _, focused ->
            if(!focused)
                binding.tvConfirmarPasswordContainer.helperText = validpasswordConfirm()
        }
    }

    private fun validpasswordConfirm(): String? {
        val passwordTextConfirmar = binding.tvConfirmarPassword.text.toString()

        return if(passwordTextConfirmar != binding.tvPasswordCuenta.text.toString())
            "La Contraseña no es la misma"
        else if(passwordTextConfirmar=="")
            "Requerido"
        else
            null
    }

}



