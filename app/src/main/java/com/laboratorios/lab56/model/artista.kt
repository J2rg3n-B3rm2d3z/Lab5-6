package com.laboratorios.lab56.model

import java.io.Serializable

//Model to use in adapter

//Se serializo para el uso de bases de datos

class artista: Serializable {

    var ArtistaNombre:String=""
    var ArtistaCategoria:String=""
    var ArtistaPais:String=""
    var ArtistaDetalle:String=""
    var ArtistaUrlImage:String=""
}