package com.laboratorios.lab56.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laboratorios.lab56.model.pintura
import com.laboratorios.lab56.network.Callback
import com.laboratorios.lab56.network.FirestoreService

class pinturaViewModel:ViewModel() {
    val firestoreService = FirestoreService()
    val listPinturas : MutableLiveData<List<pintura>> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getScheduleFromFirebase()
    }

    private fun getScheduleFromFirebase() {
        firestoreService.getgaleria(object: Callback<List<pintura>> {
            override fun onSuccess(result: List<pintura>?) {
                listPinturas.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished (){
        isLoading.value = true
    }

}