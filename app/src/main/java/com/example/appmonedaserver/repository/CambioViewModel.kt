package com.example.appmonedaserver.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.appmonedaserver.db.Cambio

class CambioViewModel(private val repositoryCambio: CambioRepository) : ViewModel() {
    val allCambio : LiveData<List<Cambio>> = repositoryCambio.allCambio.asLiveData()
}

class CambioViewModelFactory(private val repositoryCambio: CambioRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CambioViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CambioViewModel(repositoryCambio ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
