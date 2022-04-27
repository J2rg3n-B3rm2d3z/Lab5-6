package com.laboratorios.lab56.views

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

    //Fullscreen dialog

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }

}