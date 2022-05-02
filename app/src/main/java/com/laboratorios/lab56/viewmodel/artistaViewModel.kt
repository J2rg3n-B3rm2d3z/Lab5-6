package com.laboratorios.lab56.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laboratorios.lab56.model.artista
import com.laboratorios.lab56.network.Callback
import com.laboratorios.lab56.network.FirestoreService

class artistaViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    val listArtista : MutableLiveData<List<artista>> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()

    //Refrescar

    fun refresh(){
        getScheduleFromFirebase()
    }

    //Obtener los datos

    private fun getScheduleFromFirebase() {
        firestoreService.getArtistas(object: Callback<List<artista>>{
            override fun onSuccess(result: List<artista>?) {
                listArtista.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    //Finish process

    fun processFinished (){
        isLoading.value = true
    }

}