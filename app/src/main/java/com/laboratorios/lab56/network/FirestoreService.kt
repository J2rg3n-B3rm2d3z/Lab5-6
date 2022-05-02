package com.laboratorios.lab56.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.model.evento
import com.laboratorios.lab56.model.pintura

//Nombre de las colecciones de como las creamos en el Firebase
const val ARTISTAS_COLLECTION_NAME="artistas"
const val EVENTOS_COLLECTION_NAME="eventos"
const val GALERIA_COLLECTION_NAME="galerias"

class FirestoreService  {
    private val firebaseFirestore = FirebaseFirestore.getInstance()
    private val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init{
        //Nos permite tener los datos offline
        firebaseFirestore.firestoreSettings=settings
    }

    //El Callback corresponde a la interfaz creada por nosotros mismos

    //Obtener la coleccion artista

    fun getArtistas(callback: Callback <List<artista>>) {
        firebaseFirestore.collection(ARTISTAS_COLLECTION_NAME)
            .orderBy("artistaNombre")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(artista::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    //Obtener la coleccion eventos

    fun getEventos(callback:Callback <List<evento>>) {
        firebaseFirestore.collection(EVENTOS_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(evento::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    //Obtener la coleccion galeria

    fun getgaleria(callback:Callback <List<pintura>>) {
        firebaseFirestore.collection(GALERIA_COLLECTION_NAME)
            .orderBy("artistaPintura")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(pintura::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}
