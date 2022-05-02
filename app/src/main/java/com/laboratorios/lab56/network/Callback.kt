package com.laboratorios.lab56.network

//Interface que se usa para la obtencion de loss datos

interface Callback<T> {
    fun onSuccess(result: T?)
    fun onFailed(exception: Exception)
}
