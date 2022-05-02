package com.laboratorios.lab56.views.ui

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.FragmentArtistDetailsBinding
import com.laboratorios.lab56.databinding.FragmentEventUbicationBinding
import com.laboratorios.lab56.model.evento
import com.laboratorios.lab56.model.pintura

class EventUbicationFragment : DialogFragment(), OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener {

    lateinit var Evento:evento

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

        Evento = arguments?.getSerializable("evento") as evento


        val toolbar: Toolbar = binding.toolbarUbicacionEvento

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = "Evento"
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            dismiss()
            Navigation.findNavController(it).navigateUp()
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }

    //Fullscreen dialog

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        //Declaracion de variables
        val zoom=16f
        val centerMap = LatLng(Evento.Latitud, Evento.Longitud)

        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(centerMap,zoom))
        val centerMark= LatLng(Evento.Latitud, Evento.Longitud)
        val markerOptions = MarkerOptions()
        markerOptions.position(centerMark)
        markerOptions.title(Evento.Lugar)

        val bitmapDraw = context?.applicationContext?.let{ ContextCompat.getDrawable(it, R.drawable.ic_locale)} as BitmapDrawable
        val smallMarker= Bitmap.createScaledBitmap(bitmapDraw.bitmap, 150, 150, false)
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker))

        googleMap?.addMarker(markerOptions)
        googleMap?.setOnMarkerClickListener(this)
        //---------------
        googleMap?.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.map_style))
    }


    override fun onMarkerClick(googleMap: Marker): Boolean {

        val bundle = bundleOf("evento" to Evento)
        findNavController(this).navigate(R.id.mubicationDetFragment, bundle)
        return true

    }

}