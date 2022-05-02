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
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.FragmentArtistDetailsBinding
import com.laboratorios.lab56.databinding.FragmentEventUbicationBinding

class EventUbicationFragment : DialogFragment() {

    private var fbinding: FragmentEventUbicationBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentEventUbicationBinding.inflate(layoutInflater)
        val view = binding.root

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    //Setup thee toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = binding.toolbarUbicacionEvento

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = "Evento"
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