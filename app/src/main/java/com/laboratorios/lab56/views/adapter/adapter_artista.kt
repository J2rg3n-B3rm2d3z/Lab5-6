import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laboratorios.lab56.R
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.model.evento
import com.laboratorios.lab56.model.pintura
import com.laboratorios.lab56.views.adapter.artista_listener

class adapter_artista(private val ArtistaListener: artista_listener) :
    RecyclerView.Adapter<adapter_artista.ArtistaViewHolder>() {

    //Values to use
    var listArtista= ArrayList<artista>()

    //Get items to the list

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int)=
        ArtistaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_artista,parent,false))

    //return the view in the fragment

    override fun onBindViewHolder(holder: ArtistaViewHolder, @SuppressLint("RecyclerView") position: Int) {
        //
        val Artista: artista = listArtista[position]
        holder.artistaNombre.text = Artista.ArtistaNombre
        holder.artistaCategoria.text =Artista.ArtistaCategoria
        holder.artistaPais.text = Artista.ArtistaPais

        holder.itemView.setOnClickListener { view ->

            val animationItem = AnimationUtils.loadAnimation(view.context, R.anim.itemevent_animation)
            view.startAnimation(animationItem)

            animationItem.setAnimationListener(object: Animation.AnimationListener{
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
                    ArtistaListener.onArtistaClicked(Artista, position)
                }

                override fun onAnimationRepeat(animation: Animation?) {

                }
            })
        }
    }

    //Para que se valla actualizando

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data:List<artista>){
        listArtista.clear()
        listArtista.addAll(data)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return listArtista.size
    }

    //Assign de item property in the holder

    inner class ArtistaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // -----
        val artistaNombre: TextView = itemView.findViewById<View>(R.id.tvArtistaNombre) as TextView
        val artistaCategoria: TextView = itemView.findViewById<View>(R.id.tvtArtistaCategoria) as TextView
        val artistaPais: TextView = itemView.findViewById<View>(R.id.tvArtistaPais) as TextView

    }
}
