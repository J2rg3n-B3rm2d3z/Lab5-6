package com.laboratorios.lab56.model

import java.io.Serializable

//Model to use in adapter

//Se serializo para el uso de bases de datos

class evento:Serializable {
    var Hora: String = ""
    var Evento: String = ""
    var Lugar: String = ""
    var Categoria: String = ""
    var Direccion: String = ""
    var Latitud: Double = 0.00
    var Longitud: Double = 0.00
    var Telefono: String = ""
    var WebSite: String = ""
    var Photo: String = ""
}
