package com.laboratorios.lab56.views.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laboratorios.lab56.R
import com.laboratorios.lab56.model.pintura
import com.squareup.picasso.Picasso

//Class to adapt in recycler view

class adapter_galeria(private val GaleriaListener:galeriaListener,
                      private val Galeria: MutableList<pintura>,
                      private val Resource:Int,
                      private val Context:Context?):
    RecyclerView.Adapter<adapter_galeria.ViewHolder>() {

    //Values to use

    private val galeria:MutableList<pintura> = Galeria
    private val resource:Int = Resource
    private val context:Context? = Context

    //Get items to the list

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val fotoPintura:ImageView = itemview.findViewById<View>(R.id.imgFotoPintura) as ImageView
        val artistaPintura:TextView = itemview.findViewById<View>(R.id.tvNombreArtista) as TextView
        val titulopintura:TextView = itemview.findViewById<View>(R.id.tvTituloPintura) as TextView
        val precioPintura:TextView = itemview.findViewById<View>(R.id.tvPrecioPintura) as TextView
    }

    //return the view in the fragment

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(resource,parent,false)
        return ViewHolder(view)

    }

    //Assign de item property in the holder

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val Pintura:pintura = galeria[position]
        holder.artistaPintura.text = Pintura.ArtistaPintura
        holder.titulopintura.text = Pintura.TituloPintura
        holder.precioPintura.text = Pintura.PrecioPintura
        Picasso.get().load(Pintura.UrlPintura).into(holder.fotoPintura)
        holder.fotoPintura.setOnClickListener{
            GaleriaListener.onGaleriaClicked(Pintura,position)
        }

    }

    override fun getItemCount() = galeria.size

}
