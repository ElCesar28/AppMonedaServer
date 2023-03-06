package com.example.appmonedaserver.db

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CambioDao {

    @Insert
    suspend fun insertar(cambio: Cambio)

    @Query("select * from Cambio")
    fun getAll(): kotlinx.coroutines.flow.Flow<List<Cambio>>

    @Query("DELETE FROM Cambio")
    fun deleteAll() : Int

    @Query("select * from Cambio order by codeMonedaCambio")
    fun getAllCambioCursor(): Cursor


}