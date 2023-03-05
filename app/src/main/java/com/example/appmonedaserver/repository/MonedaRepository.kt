package com.example.appmonedaserver.repository

import com.example.appmonedaserver.db.Moneda
import com.example.appmonedaserver.db.MonedaDao
import kotlinx.coroutines.flow.Flow

class MonedaRepository(private val monedaDao: MonedaDao) {
    val allMonedas: Flow<List<Moneda>>
        get() = monedaDao.getAll()
}