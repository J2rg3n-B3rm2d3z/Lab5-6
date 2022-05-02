package com.laboratorios.lab56.views.ui

import adapter_artista
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.FragmentArtistBinding
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.model.pintura
import com.laboratorios.lab56.viewmodel.artistaViewModel
import com.laboratorios.lab56.viewmodel.pinturaViewModel
import com.laboratorios.lab56.views.adapter.adapter_galeria
import com.laboratorios.lab56.views.adapter.artista_listener

class ArtistFragment : Fragment() , artista_listener {

    private var fbinding: FragmentArtistBinding? = null
    private val binding get() = fbinding!!

    //---
    private lateinit var artistaAdapter: adapter_artista
    private lateinit var viewModel: artistaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentArtistBinding.inflate(layoutInflater)
        val view = binding.root

        //setup recycler view

        viewModel = ViewModelProviders.of(this)[artistaViewModel::class.java]
        viewModel.refresh()
        artistaAdapter = adapter_artista(this)

        binding.rvArtista.apply {
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
            adapter = artistaAdapter

        }
        observeViewModel()


        return view
    }

    private fun observeViewModel() {
        viewModel.listArtista.observe(viewLifecycleOwner, Observer<List<artista>>{ artista ->
            artistaAdapter.updateData(artista)
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer{
            if(it!=null){
                binding.progressgaleria.visibility = View.INVISIBLE
            }
        })
    }

    //Get the fragment in the Listener

    override fun onArtistaClicked(Artista: artista, position: Int) {
        val bundle = bundleOf("artista" to Artista)
        NavHostFragment.findNavController(this).navigate(R.id.martistDetailsFragment,bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

}
