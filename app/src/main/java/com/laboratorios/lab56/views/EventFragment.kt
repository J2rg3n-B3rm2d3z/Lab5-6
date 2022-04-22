package com.laboratorios.lab56.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.FragmentArtistBinding
import com.laboratorios.lab56.databinding.FragmentEventBinding
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.model.evento
import com.laboratorios.lab56.views.adapter.adapter_evento
import com.laboratorios.lab56.views.adapter.eventoListener

class EventFragment : Fragment(), eventoListener {

    private var fbinding: FragmentEventBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentEventBinding.inflate(layoutInflater)
        val view = binding.root

        //setup recycler view

        val reciclerevento = binding.rvEventos
        val linearmanager = LinearLayoutManager(context)
        linearmanager.orientation = LinearLayoutManager.VERTICAL
        reciclerevento.layoutManager = linearmanager

        //Start recycler view

        val adapter = adapter_evento(this, GetEvento(), R.layout.item_evento, context)
        reciclerevento.adapter = adapter

        return view
    }

    //Get the fragment in the Listener

    override fun onEventoClicked(Evento: evento, position: Int) {
        NavHostFragment.findNavController(this).navigate(R.id.meventUbicationFragment)
    }

    //Cargar eventos

    private fun GetEvento(): MutableList<evento>{
        val EventoList: MutableList<evento> = ArrayList()
        EventoList.add(evento("00:37","La tarde oscura","Pintura en Oleo"))
        EventoList.add(evento("03:49","Amanecer", "Pintura en Oleo"))
        EventoList.add(evento("06:52", "Acrílico", "Pintura en Oleo"))
        EventoList.add(evento("07:52", "Arte", "Pintura en Oleo"))
        EventoList.add(evento("09:35", "Oleo", "Pintura en Oleo"))
        EventoList.add(evento("09:46","Volcan","Pintura en Oleo"))
        EventoList.add(evento("11:30","Invierno", "Pintura en Oleo"))
        EventoList.add(evento("16:06", "Romero", "Pintura en Oleo"))
        EventoList.add(evento("17:13", "Limbo", "Pintura en Oleo"))
        EventoList.add(evento("19:09", "Resurrecion", "Pintura en Oleo"))
        EventoList.add(evento("19:57","Nachos","Pintura en Oleo"))
        EventoList.add(evento("20:13","Grafito", "Pintura en Oleo"))
        EventoList.add(evento("20:50", "Tortillas", "Pintura en Oleo"))
        EventoList.add(evento("21:54", "Reunion", "Pintura en Oleo"))
        EventoList.add(evento("23:59", "Evento", "Pintura en Oleo"))
        return EventoList
    }

}