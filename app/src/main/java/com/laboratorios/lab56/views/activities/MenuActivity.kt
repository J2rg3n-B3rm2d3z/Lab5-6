package com.laboratorios.lab56.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.Navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.ActivityMenuBinding
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.model.evento
import com.laboratorios.lab56.model.pintura
import org.json.JSONArray
import org.json.JSONObject

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding use to set View in the screen

        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarNavegacion()

        //this code just execute one time to create the database
        /*
        val firesbaseFirestore = FirebaseFirestore.getInstance()
        val jsonArrEvento = JSONArray("[\n" +
                "            {\n" +
                "                'hora' : '00:37',\n" +
                "                'evento' : 'GP de Bahrein',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '03:49',\n" +
                "                'evento' : 'GP de Arabia Saudi',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '06:52',\n" +
                "                'evento' : 'GP de Australia',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '07:52.',\n" +
                "                'evento' : 'GP de Romaña',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '09:35',\n" +
                "                'evento' : 'GP de España',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '09:46',\n" +
                "                'evento' : 'GP de MIAMI',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '11:30',\n" +
                "                'evento' : 'GP de Austria',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '16:06',\n" +
                "                'evento' : 'GP de Belgica',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '17:13',\n" +
                "                'evento' : 'GP de Italia',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '19:09',\n" +
                "                'evento' : 'GP de Singapur',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '19:57',\n" +
                "                'evento' : 'GP de Brasil',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '20:13',\n" +
                "                'evento' : 'GP de Japon',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            },\n" +
                "            {\n" +
                "                'hora' : '20:50',\n" +
                "                'evento' : 'GP de Francia',\n" +
                "                'categoria' : 'Carrera'\n" +
                "            }\n" +
                "        ]")

        val jsonArrArtista = JSONArray("[\n" +
                "            {\n" +
                "                'nombreartista' : 'George Russell',\n" +
                "                'categoriaartista' : 'Mercedes',\n" +
                "                'detalleartista' : '(Texto de relleno) Nací en España Madrid, soy corredor para el equipo de Ferrari de formula1, esta pasión fue inspirada en gran parte gracias a mi padre que me enseño sus pasos',\n"+
                "                'paisartista' : 'España'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Lewis Hamilton',\n" +
                "                'categoriaartista' : 'Mercedes',\n" +
                "                'detalleartista' : '(Texto de relleno) Nací en España Madrid, soy corredor para el equipo de Ferrari de formula1, esta pasión fue inspirada en gran parte gracias a mi padre que me enseño sus pasos',\n"+
                "                'paisartista' : 'España'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Fernando Alonso',\n" +
                "                'categoriaartista' : 'Alpine',\n" +
                "                'detalleartista' : '(Texto de relleno) Nací en España Madrid, soy corredor para el equipo de Ferrari de formula1, esta pasión fue inspirada en gran parte gracias a mi padre que me enseño sus pasos',\n"+
                "                'paisartista' : 'España'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Esteban Ocon',\n" +
                "                'categoriaartista' : 'Alpine',\n" +
                "                'detalleartista' : '(Texto de relleno) Nací en España Madrid, soy corredor para el equipo de Ferrari de formula1, esta pasión fue inspirada en gran parte gracias a mi padre que me enseño sus pasos',\n"+
                "                'paisartista' : 'España'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Kevin Magnussen',\n" +
                "                'categoriaartista' : 'Haas',\n" +
                "                'detalleartista' : '(Texto de relleno) Nací en España Madrid, soy corredor para el equipo de Ferrari de formula1, esta pasión fue inspirada en gran parte gracias a mi padre que me enseño sus pasos',\n"+
                "                'paisartista' : 'Alemania'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Mick Schumacher',\n" +
                "                'categoriaartista' : 'Haas',\n" +
                "                'detalleartista' : '(Texto de relleno) Nací en España Madrid, soy corredor para el equipo de Ferrari de formula1, esta pasión fue inspirada en gran parte gracias a mi padre que me enseño sus pasos',\n"+
                "                'paisartista' : 'Nueva Zelanda'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Daniel Ricciardo',\n" +
                "                'categoriaartista' : 'Mclaren',\n" +
                "                'detalleartista' : '(Texto de relleno) Nací en España Madrid, soy corredor para el equipo de Ferrari de formula1, esta pasión fue inspirada en gran parte gracias a mi padre que me enseño sus pasos',\n"+
                "                'paisartista' : 'Australia'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Lando Norris',\n" +
                "                'categoriaartista' : 'Mclaren',\n" +
                "                'detalleartista' : '(Texto de relleno) Nací en España Madrid, soy corredor para el equipo de Ferrari de formula1, esta pasión fue inspirada en gran parte gracias a mi padre que me enseño sus pasos',\n"+
                "                'paisartista' : 'Australia'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Valtteri Bottas',\n" +
                "                'categoriaartista' : 'Alfa Romeo',\n" +
                "                'detalleartista' : '(Texto de relleno) Nací en España Madrid, soy corredor para el equipo de Ferrari de formula1, esta pasión fue inspirada en gran parte gracias a mi padre que me enseño sus pasos',\n"+
                "                'paisartista' : 'Finlandia'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Guanyu Zhou',\n" +
                "                'categoriaartista' : 'Alfa Romeo',\n" +
                "                'detalleartista' : '(Texto de relleno) Nací en España Madrid, soy corredor para el equipo de Ferrari de formula1, esta pasión fue inspirada en gran parte gracias a mi padre que me enseño sus pasos',\n"+
                "                'paisartista' : 'Finlandia'\n" +
                "            }\n" +
                "        ]")

        val jsonGaleria = JSONArray("[\n" +
                "            {\n" +
                "                'artistapintura' : 'Autódromu',\n" +
                "                'preciopintura' : '1997-2003',\n" +
                "                'urlpintura' : 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Red_Bull_Ring%2C_April_18%2C_2018_SkySat.jpg/1280px-Red_Bull_Ring%2C_April_18%2C_2018_SkySat.jpg',\n" +
                "                'detallepintura' : '(Texto de relleno) Bahrain Grand Prix, conocido oficialmente como Bahrain Grand Prix de Gulf Air por motivos de patrocinio, es un evento de carreras de Fórmula Uno en Bahrein. La primera carrera tuvo lugar en el Circuito Internacional de Bahrein el 4 de abril de 2004',\n"+
                "                'titulopintura' : 'Red Bull Ring'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistapintura' : 'Hibrido',\n" +
                "                'preciopintura' : '2004-2010',\n" +
                "                'urlpintura' : 'https://upload.wikimedia.org/wikipedia/commons/1/10/2012_Bahrain_Grand_Prix_2.jpg',\n" +
                "                'detallepintura' : '(Texto de relleno) Bahrain Grand Prix, conocido oficialmente como Bahrain Grand Prix de Gulf Air por motivos de patrocinio, es un evento de carreras de Fórmula Uno en Bahrein. La primera carrera tuvo lugar en el Circuito Internacional de Bahrein el 4 de abril de 2004',\n"+
                "                'titulopintura' : 'Bahrain Grand Prix'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistapintura' : 'Autódromu',\n" +
                "                'preciopintura' : '1999',\n" +
                "                'urlpintura' : 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/F1_Circuit_de_Catalunya_-_Tribuna.jpg/1024px-F1_Circuit_de_Catalunya_-_Tribuna.jpg',\n" +
                "                'detallepintura' : '(Texto de relleno) Bahrain Grand Prix, conocido oficialmente como Bahrain Grand Prix de Gulf Air por motivos de patrocinio, es un evento de carreras de Fórmula Uno en Bahrein. La primera carrera tuvo lugar en el Circuito Internacional de Bahrein el 4 de abril de 2004',\n"+
                "                'titulopintura' : 'Circuito de Catalunya'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistapintura' : 'Autódromu',\n" +
                "                'preciopintura' : '2009',\n" +
                "                'urlpintura' : 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Autodromo_aerea_poster.jpg/1024px-Autodromo_aerea_poster.jpg',\n" +
                "                'detallepintura' : '(Texto de relleno) Bahrain Grand Prix, conocido oficialmente como Bahrain Grand Prix de Gulf Air por motivos de patrocinio, es un evento de carreras de Fórmula Uno en Bahrein. La primera carrera tuvo lugar en el Circuito Internacional de Bahrein el 4 de abril de 2004',\n"+
                "                'titulopintura' : 'Autodromo Aerea'\n" +
                "            }\n" +
                "        ]")

        for (i in 0 until jsonArrEvento.length()) {
            val objevento = jsonArrEvento.get(i) as JSONObject
            var Evento = evento()

            Evento.Hora = objevento.getString("hora")
            Evento.Evento = objevento.getString("evento")
            Evento.Categoria = objevento.getString("categoria")
            firesbaseFirestore.collection("eventos").document().set(Evento)
        }

        for (i in 0 until jsonArrArtista.length())
        {
            val objArtista = jsonArrArtista.get(i) as JSONObject
            var Artista = artista()

            Artista.ArtistaNombre = objArtista.getString("nombreartista")
            Artista.ArtistaCategoria = objArtista.getString("categoriaartista")
            Artista.ArtistaPais = objArtista.getString("paisartista")
            Artista.ArtistaDetalle = objArtista.getString("detalleartista")
            firesbaseFirestore.collection("artistas").document().set(Artista)
        }


        for (i in 0 until jsonGaleria.length())
        {
            val objGaleria = jsonGaleria.get(i) as JSONObject
            var Galeria = pintura()

            Galeria.ArtistaPintura = objGaleria.getString("artistapintura")
            Galeria.PrecioPintura = objGaleria.getString("preciopintura")
            Galeria.UrlPintura = objGaleria.getString("urlpintura")
            Galeria.TituloPintura = objGaleria.getString("titulopintura")
            Galeria.DetallePintura = objGaleria.getString("detallepintura")
            firesbaseFirestore.collection("galerias").document().set(Galeria)
        }
        */

    }

    private fun configurarNavegacion()
    {
        //Navigation controller

        val menuArtList:BottomNavigationView = binding.bottomNavMenu
        setupWithNavController(menuArtList, findNavController(this,R.id.frag_navgraph))


    }


}