package com.laboratorios.lab56.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
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

        //Verificar si los campos estan enfocados
        //y no tiene errores

        emailFocusListener()
        passswordFocusListener()

    }

    private fun emailFocusListener() {
        binding.tvUserName.setOnFocusChangeListener { _, focused ->
            if(!focused)
                binding.tvUserNameContainer.helperText = validEmail()
        }
    }

    private fun validEmail(): String? {
        val userText = binding.tvUserName.text.toString()

        return if(!Patterns.EMAIL_ADDRESS.matcher(userText).matches())
            "E-mail invalido"
        else if(userText=="")
            "Requerido"
        else
            null
    }

    private fun passswordFocusListener() {
        binding.password.setOnFocusChangeListener { _, focused ->
            if(!focused)
                binding.passwordContainer.helperText = validpasssword()
        }
    }

    private fun validpasssword(): String? {
        val passwordText = binding.password.text.toString()

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

    //Function to button when click in Login

    fun onClickArteLista (view: View){

        val passwordText = binding.password.text.toString()
        val userText = binding.tvUserName.text.toString()

        if(Patterns.EMAIL_ADDRESS.matcher(userText).matches() && passwordText.length >= 3 &&
            passwordText.length <= 8 &&
            (passwordText.matches(".*[a-z].*".toRegex()) ||
                    passwordText.matches(".*[A-Z].*".toRegex())) &&
            passwordText.matches(".*[0-9].*".toRegex())){

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)

        }
    }

    //Function to button to switch a createAccount Activity

    fun onClickCrearCuenta(view: View) {
        val intent = Intent(this, CreateAccountActivity::class.java)
        startActivity(intent)
    }

}