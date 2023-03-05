package com.example.appmonedaserver.network

import com.example.appmonedaserver.db.Moneda
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private const val BASE_URL = "https://open.er-api.com/v6/latest/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CambioApiService {
    @GET("MXN")
    suspend fun getCambioApi(): Response
}

object CambioApi {
    val retrofitService : CambioApiService by lazy {
        retrofit.create(CambioApiService::class.java) }
}