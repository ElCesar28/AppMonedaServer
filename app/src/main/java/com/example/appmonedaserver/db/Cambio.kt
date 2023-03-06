package com.example.appmonedaserver.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity
data class Cambio (
    @PrimaryKey(autoGenerate = true)
    val  _IDCambio: Int ,
    val codeMonedaCambio: String,
    val cambio: String,
    val fechaActualizacion: String

)