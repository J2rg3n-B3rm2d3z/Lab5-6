package com.laboratorios.lab56.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.Navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding use to set View in the screen

        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Navigation controller

        val menuArtList:BottomNavigationView = binding.bottomNavMenu
        setupWithNavController(menuArtList, findNavController(this,R.id.frag_navgraph))

    }
}