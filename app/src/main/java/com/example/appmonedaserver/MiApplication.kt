package com.example.appmonedaserver

import android.app.Application
import android.util.Log
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.appmonedaserver.db.MiDbMonedas
import com.example.appmonedaserver.network.CambioApi
import com.example.appmonedaserver.repository.MonedaRepository
import com.example.appmonedaserver.work.saveWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MiApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { MiDbMonedas.getDatabase(this, applicationScope) }
    val repositoryMoneda by lazy {  MonedaRepository (database.monedaDao()) }

    override fun onCreate() {
        super.onCreate()
        val workRequest = PeriodicWorkRequestBuilder<saveWorker>(5, TimeUnit.MINUTES).build()
        WorkManager.getInstance(applicationContext).enqueue(workRequest)

    }
}