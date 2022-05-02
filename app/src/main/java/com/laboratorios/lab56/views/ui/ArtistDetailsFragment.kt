package com.laboratorios.lab56.views.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.FragmentArtistDetailsBinding
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.model.pintura
import com.squareup.picasso.Picasso

class ArtistDetailsFragment : DialogFragment() {

    private var fbinding: FragmentArtistDetailsBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        fbinding = FragmentArtistDetailsBinding.inflate(layoutInflater)
        val view = binding.root

        //Obtiene el objeto que se paso en el fragment anterior y se usa para
        //Asignarlo en el binding para mostrarlo en pantalla

        val Artista =  arguments?.getSerializable("artista") as artista

        binding.tvNombrePerfil.text = Artista.ArtistaNombre
        binding.tvCiudadPerfil.text = Artista.ArtistaPais
        binding.tvDescripcionAcerca.text = Artista.ArtistaDetalle
        Picasso.get().load(Artista.ArtistaUrlImage).into(binding.imgPerfil)


        //Code to use the button to open n close

        binding.btnAcercaDe.setOnClickListener{
            if(binding.tvDescripcionAcerca.visibility==View.VISIBLE){
                binding.tvDescripcionAcerca.visibility=View.INVISIBLE
                binding.btnAcercaDe.background = ContextCompat.getDrawable(view.context,R.drawable.ic_down)
                AnimationUtils.loadAnimation(view.context,androidx.appcompat.R.anim.abc_slide_in_bottom).also { animboton ->
                    binding.tvDescripcionAcerca.startAnimation(animboton)
                }
            }
            else{
                binding.tvDescripcionAcerca.visibility=View.VISIBLE
                binding.btnAcercaDe.background = ContextCompat.getDrawable(view.context,R.drawable.ic_up)
                AnimationUtils.loadAnimation(view.context,androidx.appcompat.R.anim.abc_slide_in_bottom).also { animboton ->
                    binding.tvDescripcionAcerca.startAnimation(animboton)
                }
            }
        }

        return view
    }

    //Setup thee toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.tooldetalleartista

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = "Corredor"
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            dismiss()
            Navigation.findNavController(it).navigateUp()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    //Fullscreen dialog

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }

}