import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laboratorios.lab56.R
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.views.adapter.artista_listener

class adapter_artista(private val ArtistaListener: artista_listener, Artista: MutableList<artista>,
                      resource: Int, context: Context?) :
    RecyclerView.Adapter<adapter_artista.ArtistaViewHolder>() {

    //Values to use

    private val artista: MutableList<artista> = Artista
    private val resource:Int = resource
    private val context: Context? = context

    //Get items to the list

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): ArtistaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return ArtistaViewHolder(view)
    }

    //return the view in the fragment

    override fun onBindViewHolder(holder: ArtistaViewHolder, position: Int) {
        //
        val Artista: artista = artista[position]
        holder.artistaNombre.text = Artista.ArtistaNombre
        holder.artistaCategoria.text =Artista.ArtistaCategoria
        holder.artistaPais.text = Artista.ArtistaPais

        holder.itemView.setOnClickListener { view ->
            ArtistaListener.onArtistaClicked(Artista, position)
        }
    }


    override fun getItemCount(): Int {
        return artista.size
    }

    //Assign de item property in the holder

    inner class ArtistaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // -----
        val artistaNombre: TextView = itemView.findViewById<View>(R.id.tvArtistaNombre) as TextView
        val artistaCategoria: TextView = itemView.findViewById<View>(R.id.tvtArtistaCategoria) as TextView
        val artistaPais: TextView = itemView.findViewById<View>(R.id.tvArtistaPais) as TextView

    }
}
