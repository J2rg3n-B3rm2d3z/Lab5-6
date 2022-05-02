package com.laboratorios.lab56.views.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laboratorios.lab56.R
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.model.evento

class adapter_evento (val EventoListener: eventoListener) :
    RecyclerView.Adapter<adapter_evento.EventoViewHolder>(){
    //Values to use

    var listEvento= ArrayList<evento>()

    //Get items to the list

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int) =
        EventoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_evento,parent,false))

    //return the view in the fragment

    override fun onBindViewHolder(holder: adapter_evento.EventoViewHolder, position: Int) {
        val Evento: evento = listEvento[position]
        holder.Hora.text = Evento.Hora
        holder.Evento.text = Evento.Evento
        holder.Categoria.text = Evento.Categoria

        holder.itemView.setOnClickListener { view ->
            EventoListener.onEventoClicked( Evento, position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data:List<evento>){
        listEvento.clear()
        listEvento.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listEvento.size
    }

    //Assign de item property in the holder

    inner class EventoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // -----
        val Hora: TextView = itemView.findViewById<View>(R.id.tvEventoHora1) as TextView
        val Evento: TextView = itemView.findViewById<View>(R.id.tvEvento) as TextView
        val Categoria: TextView = itemView.findViewById<View>(R.id.tvEventoCategoria) as TextView
    }

}