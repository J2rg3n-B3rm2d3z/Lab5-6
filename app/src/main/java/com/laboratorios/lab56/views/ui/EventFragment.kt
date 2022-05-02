package com.laboratorios.lab56.views.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.FragmentArtistBinding
import com.laboratorios.lab56.databinding.FragmentEventBinding
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.model.evento
import com.laboratorios.lab56.viewmodel.artistaViewModel
import com.laboratorios.lab56.viewmodel.eventoViewModel
import com.laboratorios.lab56.views.adapter.adapter_evento
import com.laboratorios.lab56.views.adapter.eventoListener

class EventFragment : Fragment(), eventoListener {

    private var fbinding: FragmentEventBinding? = null
    private val binding get() = fbinding!!

    //--
    private lateinit var eventoAdapter: adapter_evento
    private lateinit var viewModel: eventoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentEventBinding.inflate(layoutInflater)
        val view = binding.root

        //setup recycler view

        viewModel = ViewModelProviders.of(this)[eventoViewModel::class.java]
        viewModel.refresh()
        eventoAdapter = adapter_evento(this)

        binding.rvEventos.apply {
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
            adapter = eventoAdapter

        }
        observeViewModel()

        return view
    }

    //funcion para cargar datos obtenidos del BBDD y mostrarlos en pantalla

    private fun observeViewModel() {
        viewModel.listEventos.observe(viewLifecycleOwner, Observer<List<evento>>{ evento ->
            eventoAdapter.updateData(evento)
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer{
            if(it!=null){
                binding.progressgaleria.visibility = View.INVISIBLE
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    //Get the fragment in the Listener

    override fun onEventoClicked(Evento: evento, position: Int) {
        val bundle = bundleOf("evento" to Evento)//Se le pasa el objeto al siguiente fragment
        NavHostFragment.findNavController(this).navigate(R.id.meventUbicationFragment,bundle)
    }

}