package com.laboratorios.lab56.model

import java.io.Serializable

//Model to use in adapter

//Se serializo para el uso de bases de datos

class evento: Serializable{
    var Hora:String = ""
    var Evento:String = ""
    var Categoria:String = ""
}