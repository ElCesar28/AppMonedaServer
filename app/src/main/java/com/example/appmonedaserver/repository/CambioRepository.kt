package com.example.appmonedaserver.repository

import com.example.appmonedaserver.db.Cambio
import com.example.appmonedaserver.db.CambioDao
import kotlinx.coroutines.flow.Flow

class CambioRepository (private val cambioDao: CambioDao) {
    val allCambio: Flow<List<Cambio>>
    get() = cambioDao.getAll()
}