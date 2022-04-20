package com.laboratorios.lab56.views.adapter

import com.laboratorios.lab56.model.pintura
import java.text.FieldPosition

//interface to use in to get an event

interface galeriaListener {
    fun onGaleriaClicked(Galeria:pintura, position: Int) {

    }
}