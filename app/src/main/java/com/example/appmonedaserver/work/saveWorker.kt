package com.example.appmonedaserver.work

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.appmonedaserver.network.CambioApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

val TAG ="WORKER"
class saveWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {

    override fun doWork(): Result {
        return try {
            GlobalScope.launch {
                try {
                    val response = CambioApi.retrofitService.getCambioApi()
                    //Guardar los cambios en el DB en la tabla Cambio

                    Log.d("API RESPONSE","VEAMOOOOOS")
                    for ((key, value) in response.rates) {
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