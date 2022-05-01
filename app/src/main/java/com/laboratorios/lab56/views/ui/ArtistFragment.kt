package com.laboratorios.lab56.views.ui

import adapter_artista
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.FragmentArtistBinding
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.views.adapter.artista_listener

class ArtistFragment : Fragment() , artista_listener {

    private var fbinding: FragmentArtistBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentArtistBinding.inflate(layoutInflater)
        val view = binding.root

        //setup recycler view

        val reciclerartista = binding.rvArtista
        val linearmanager = LinearLayoutManager(context)
        linearmanager.orientation = LinearLayoutManager.VERTICAL
        reciclerartista.layoutManager = linearmanager

        //Start recycler view

        val adapter = adapter_artista(this, GetArtista(), R.layout.item_artista, context)
        reciclerartista.adapter = adapter
        return view
    }

    //Get the fragment in the Listener

    override fun onArtistaClicked(Artista: artista, position: Int) {
        NavHostFragment.findNavController(this).navigate(R.id.martistDetailsFragment)
    }

    //Cargar obras de arte

    private fun GetArtista(): MutableList<artista>{
        val artistaList: MutableList<artista> = ArrayList()
        artistaList.add(artista("George Russell","Mercedes","España"))
        artistaList.add(artista("Lewis Hamilton","Mercedes", "España"))
        artistaList.add(artista("Fernando Alonso", "Alpine", "España"))
        artistaList.add(artista("Esteban Ocon", "Alpine", "España"))
        artistaList.add(artista("Kevin Magnussen", "Haas", "Alemania"))
        artistaList.add(artista("Mick Schumacher","Haas","Nueva Zelanda"))
        artistaList.add(artista("Daniel Ricciardo","Mclaren", "Australia"))
        artistaList.add(artista("Lando Norris", "Mclaren", "Australia"))
        artistaList.add(artista("Valtteri Bottas", "Alfa Romeo", "Finlandia"))
        artistaList.add(artista("Guanyu Zhou", "Alfa Romeo", "Finlandia"))
        artistaList.add(artista("Sergio Pérez","Red Bull","Nueva Zelanda"))
        artistaList.add(artista("Max Verstapen","Red Bull", "China"))
        artistaList.add(artista("Charles Leclerc", "Ferrari", "Francia"))
        artistaList.add(artista("Carlos Sainz", "Ferrari", "España"))
        artistaList.add(artista("Pierre Gasly", "Alphatauri", "Francia"))
        return artistaList
    }
}
