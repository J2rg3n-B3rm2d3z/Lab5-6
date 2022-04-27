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
import com.laboratorios.lab56.model.pintura
import com.laboratorios.lab56.views.adapter.adapter_galeria
import com.laboratorios.lab56.views.adapter.galeriaListener


class GalleryFragment : Fragment(), galeriaListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view:View = inflater.inflate(R.layout.fragment_gallery, container, false)

        //Setup the recycler view

        val reciclergaleria = view.findViewById<View>(R.id.rvgaleria) as RecyclerView
        val linearmanager = LinearLayoutManager(context)
        linearmanager.orientation = LinearLayoutManager.VERTICAL
        reciclergaleria.layoutManager = linearmanager

        val adapter = adapter_galeria(this,getGaleria(), R.layout.item_galeria, context)
        reciclergaleria.adapter = adapter
        return view

    }

    //Use the interface galeriaListener to use the event

    @Override
    override fun onGaleriaClicked(Galeria: pintura, position: Int) {
        super.onGaleriaClicked(Galeria, position)
        NavHostFragment.findNavController(this).navigate(R.id.mgalleryDetailsFragment)
    }

    //Get the List to use in the recycler view

    private fun getGaleria(): MutableList<pintura>{
        // we have to create a list with drivers of f1
        val galeriaList: MutableList<pintura> = ArrayList()
        galeriaList.add(pintura("Autódromu","1997-2003","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Red_Bull_Ring%2C_April_18%2C_2018_SkySat.jpg/1280px-Red_Bull_Ring%2C_April_18%2C_2018_SkySat.jpg","Red Bull Ring"))
        galeriaList.add(pintura("Hibirido","2004-2010", "https://upload.wikimedia.org/wikipedia/commons/1/10/2012_Bahrain_Grand_Prix_2.jpg", "Bahrain Grand Prix"))
        galeriaList.add(pintura("Autódromu", "1999", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/F1_Circuit_de_Catalunya_-_Tribuna.jpg/1024px-F1_Circuit_de_Catalunya_-_Tribuna.jpg", "Circuito de Catalunya"))
        galeriaList.add(pintura("Autódromu", "2009", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Autodromo_aerea_poster.jpg/1024px-Autodromo_aerea_poster.jpg", "Autodromo Aerea"))
        return galeriaList
    }




}