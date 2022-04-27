package com.laboratorios.lab56.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.compose.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.FragmentGalleryBinding
import com.laboratorios.lab56.databinding.FragmentGalleryDetailsBinding
import com.laboratorios.lab56.model.pintura
import com.laboratorios.lab56.views.adapter.adapter_galeria
import com.laboratorios.lab56.views.adapter.galeriaListener


class GalleryFragment : Fragment(), galeriaListener {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val view = binding.root

        //Setup the recycler view

        val reciclergaleria = view.findViewById<View>(R.id.rvgaleria) as RecyclerView
        val linearmanager = LinearLayoutManager(context)
        linearmanager.orientation = LinearLayoutManager.VERTICAL
        reciclergaleria.layoutManager = linearmanager

        val adapter = adapter_galeria(this,getGaleria(), R.layout.item_galeria, context)
        reciclergaleria.adapter = adapter

        return view
    }

    //Override the Ondestroy

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Use the interface galeriaListener to use the event

    @Override
    override fun onGaleriaClicked(Galeria: pintura, position: Int) {
        super.onGaleriaClicked(Galeria, position)
        NavHostFragment.findNavController(this).navigate(R.id.mgalleryDetailsFragment)
    }

    //Get the List to use in the recycler view

    private fun getGaleria(): MutableList<pintura>{
        val galeriaList: MutableList<pintura> = ArrayList()
        galeriaList.add(pintura("Haniel Herrera","1,600","https://artelista.s3.amazonaws.com/obras/big/3/5/5/1209702-607458d7c0c2a.jpg","Memories"))
        galeriaList.add(pintura("Jesús Cuenca","1,200", "https://artelista.s3.amazonaws.com/obras/big/1/6/4/1209582.jpg", "Rancio"))
        galeriaList.add(pintura("Pol Ledent", "1,600", "https://artelista.s3.amazonaws.com/obras/fichas/1/4/6/1209343.jpg", "Como en invierno"))
        galeriaList.add(pintura("Maribel Flores", "1,600", "https://artelista.s3.amazonaws.com/obras/big/7/4/1/1228034.jpg", "Blossom"))
        galeriaList.add(pintura("Nana Tchelidze", "575", "https://artelista.s3.amazonaws.com/obras/big/1/1/4/1228154.jpg", "El Puente"))
        return galeriaList
    }




}