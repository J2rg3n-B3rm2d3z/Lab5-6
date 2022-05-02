package com.laboratorios.lab56.views.ui

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.google.android.material.textview.MaterialTextView
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.FragmentEventBinding
import com.laboratorios.lab56.databinding.FragmentUbicationDetBinding
import com.laboratorios.lab56.model.evento
import com.squareup.picasso.Picasso

class UbicationDetFragment : DialogFragment() {

    lateinit var Evento:evento

    private var _binding: FragmentUbicationDetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUbicationDetBinding.inflate(layoutInflater)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Configurar el toolbar
        val toolbar: Toolbar = view.findViewById(R.id.toolubicaciondetalle)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.navigationIcon= ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbar.title = "Detalle Ubicación"
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            dismiss()
            Navigation.findNavController(it).navigateUp()
        }

        //Se obtiene el objeto que se paso en el fragment anterior y se usa

        Evento = arguments?.getSerializable("evento") as evento

        val txtLugarEvento: MaterialTextView = binding.txtLugarEvento as MaterialTextView
        val txtDireccionEvento: MaterialTextView = binding.txtDireccionEvento as MaterialTextView
        val txtTelefonoEvento: MaterialTextView = binding.txtTelefonoEvento as MaterialTextView
        val txtWebSiteEvento: MaterialTextView = binding.txtSitioWebEvento as MaterialTextView

        txtLugarEvento.text = Evento.Lugar
        txtDireccionEvento.text = Evento.Direccion
        txtTelefonoEvento.text = Evento.Telefono
        txtWebSiteEvento.text = Evento.WebSite
        Picasso.get().load(Evento.Photo).into(binding.imgubicacion)

        //Al dar click al numero de telefono o a la pagina web
        //Te llevaran a la aplicacion de telefono o a chrome

        txtWebSiteEvento.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(txtWebSiteEvento.text as String)
            startActivity(intent)
        }
        txtTelefonoEvento.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${txtTelefonoEvento.text}")
            }
            startActivity(intent)
        }
    }

    //Maximizar el fragment

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    //Personalizar el fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogStyle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}