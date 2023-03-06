package com.example.appmonedaserver.work

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.text.TextUtils
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.appmonedaserver.MiApplication
import com.example.appmonedaserver.db.Cambio
import com.example.appmonedaserver.db.MiDbMonedas
import com.example.appmonedaserver.network.CambioApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime

val TAG ="WORKER"
private lateinit var db: MiDbMonedas
@RequiresApi(Build.VERSION_CODES.O)
val currentDate = LocalDateTime.now()
class saveWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun doWork(): Result {

        return try {
            GlobalScope.launch {
                db = (applicationContext as MiApplication).database
                try {
                    val response = CambioApi.retrofitService.getCambioApi()
                    //Guardar los cambios en el DB en la tabla Cambio

                    Log.d("API RESPONSE","VEAMOOOOOS")
                    for ((key, value) in response.rates) {
                        db.cambioDao().insertar(Cambio(0,key,value.toString(), response.time_last_update_utc,
                            currentDate.toString()))
                        println("Clave: $key Valor: $value")
                    }
                    println("Ultima actualización: ${response.time_last_update_utc}")
                } catch (e: Exception) {
                    Log.d("TAG", "NOOOOOOOOOOOOO ${e}");

                }
            }

            Result.success()
        } catch (throwable: Throwable) {
            Log.e(TAG, "Error applying blur")
            throwable.printStackTrace()
            Result.failure()
        }
    }
}