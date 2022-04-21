package com.laboratorios.lab56.views.adapter

import com.laboratorios.lab56.model.artista

interface artista_listener {
    fun onArtistaClicked(Artista: artista, position:Int)
}