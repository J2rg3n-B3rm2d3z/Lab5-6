package com.laboratorios.lab56.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laboratorios.lab56.model.evento
import com.laboratorios.lab56.network.Callback
import com.laboratorios.lab56.network.FirestoreService

class eventoViewModel: ViewModel() {

    val firestoreService = FirestoreService()
    val listEventos : MutableLiveData<List<evento>> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()

    //Refrescar

    fun refresh(){
        getScheduleFromFirebase()
    }

    //Obtener los datos

    private fun getScheduleFromFirebase() {
        firestoreService.getEventos(object: Callback<List<evento>> {
            override fun onSuccess(result: List<evento>?) {
                listEventos.postValue(result)
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