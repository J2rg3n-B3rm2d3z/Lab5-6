package com.laboratorios.lab56.views.ui

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
import com.laboratorios.lab56.databinding.FragmentGalleryBinding
import com.laboratorios.lab56.model.pintura
import com.laboratorios.lab56.viewmodel.pinturaViewModel
import com.laboratorios.lab56.views.adapter.adapter_galeria
import com.laboratorios.lab56.views.adapter.galeriaListener

class GalleryFragment : Fragment(), galeriaListener {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    //----
    private lateinit var galeriaAdapter: adapter_galeria
    private lateinit var viewModel:pinturaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val view = binding.root

        //setup recycler view

        viewModel = ViewModelProviders.of(this)[pinturaViewModel::class.java]
        viewModel.refresh()
        galeriaAdapter = adapter_galeria(this)

        binding.rvgaleria.apply {
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
            adapter = galeriaAdapter

        }
        observeViewModel()


        return view
    }

    //funcion para cargar datos obtenidos del BBDD y mostrarlos en pantalla

    private fun observeViewModel() {
        viewModel.listPinturas.observe(viewLifecycleOwner, Observer<List<pintura>>{ galeria ->
            galeriaAdapter.updateData(galeria)
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer{
            if(it!=null){
                binding.progressgaleria.visibility = View.INVISIBLE
            }
        })
    }

    //Override the Ondestroy

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Use the interface galeriaListener to use the event

    @Override
    override fun onGaleriaClicked(Galeria: pintura, position: Int) {
        val bundle = bundleOf("galerias" to Galeria)//Se le pasa el objeto al siguiente fragment
        NavHostFragment.findNavController(this).navigate(R.id.mgalleryDetailsFragment,bundle)
    }
}