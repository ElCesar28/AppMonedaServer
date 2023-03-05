package com.example.appmonedaserver

import android.app.Application
import com.example.appmonedaserver.db.MiDbMonedas
import com.example.appmonedaserver.repository.MonedaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MiApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { MiDbMonedas.getDatabase(this, applicationScope) }
    val repositoryMoneda by lazy {  MonedaRepository (database.monedaDao()) }

    override fun onCreate() {
        super.onCreate()

    }
}