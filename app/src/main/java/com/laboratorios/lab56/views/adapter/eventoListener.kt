package com.laboratorios.lab56.views.adapter

import com.laboratorios.lab56.model.evento

interface eventoListener {
    fun onEventoClicked(Evento: evento, position:Int)
}