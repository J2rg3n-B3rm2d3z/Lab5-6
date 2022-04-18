package com.laboratorios.lab56.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.Navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.laboratorios.lab56.R

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        //Navigation controller

        val menuArtList:BottomNavigationView = findViewById(R.id.bottomNavMenu)
        setupWithNavController(menuArtList, findNavController(this,R.id.frag_navgraph))

    }
}