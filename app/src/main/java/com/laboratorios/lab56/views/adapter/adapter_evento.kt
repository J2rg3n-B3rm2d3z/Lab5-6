package com.laboratorios.lab56.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laboratorios.lab56.R
import com.laboratorios.lab56.model.evento

class adapter_evento (private val EventoListener: eventoListener, Evento: MutableList<evento>,
                      resource: Int, context: Context?) :
    RecyclerView.Adapter<adapter_evento.EventoViewHolder>(){
    //Values to use

    private val evento: MutableList<evento> = Evento
    private val resource:Int = resource
    private val context: Context? = context

    //Get items to the list

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): EventoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return EventoViewHolder(view)
    }

    //return the view in the fragment

    override fun onBindViewHolder(holder: adapter_evento.EventoViewHolder, position: Int) {
        val Evento: evento = evento[position]
        holder.Hora.text = Evento.Hora
        holder.Evento.text = Evento.Evento
        holder.Categoria.text = Evento.Categoria

        holder.itemView.setOnClickListener { view ->
            EventoListener.onEventoClicked( Evento, position)
        }
    }

    override fun getItemCount(): Int {
        return evento.size
    }

    //Assign de item property in the holder

    inner class EventoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // -----
        val Hora: TextView = itemView.findViewById<View>(R.id.tvEventoHora1) as TextView
        val Evento: TextView = itemView.findViewById<View>(R.id.tvEvento) as TextView
        val Categoria: TextView = itemView.findViewById<View>(R.id.tvEventoCategoria) as TextView
    }

}