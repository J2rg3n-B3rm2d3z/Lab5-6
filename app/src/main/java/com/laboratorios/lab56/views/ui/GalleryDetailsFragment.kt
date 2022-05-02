package com.laboratorios.lab56.views.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.laboratorios.lab56.databinding.FragmentGalleryDetailsBinding
import com.laboratorios.lab56.model.pintura
import com.squareup.picasso.Picasso

class GalleryDetailsFragment : DialogFragment() {

    //Binding View

    var Titulo:String = ""

    private var _binding: FragmentGalleryDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        val galeria = arguments?.getSerializable("galerias") as pintura

        binding.tvArtistaDetalle.text = galeria.ArtistaPintura
        Titulo = galeria.TituloPintura +" - ( " + galeria.PrecioPintura + " )"
        binding.txtDetalleArte.text = galeria.DetallePintura
        Picasso.get().load(galeria.UrlPintura).into(binding.imgDetalleArte)

        return view
    }

    //Override the Ondestroy

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Setup the toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.tooldetallegaleria

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = Titulo
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            dismiss()
            Navigation.findNavController(it).navigateUp()
        }
    }

    //Fullscreen dialog

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }



}