package com.laboratorios.lab56.model

import java.io.Serializable

//Model to use in Adapters

//Se serializo para el uso de bases de datos

class pintura: Serializable {
    var ArtistaPintura:String=""
    var PrecioPintura:String=""
    var UrlPintura:String=""
    var TituloPintura:String=""
    var DetallePintura:String=""
}