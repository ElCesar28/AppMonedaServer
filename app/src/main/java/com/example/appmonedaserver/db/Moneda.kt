package com.example.appmonedaserver.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Moneda (
    @PrimaryKey(autoGenerate = true)
    val  _ID: Int ,
    val codeMoneda: String,
    val nombreMoneda: String,
    val pais : String
)