package com.example.appmonedaserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import com.example.appmonedaserver.R
import com.example.appmonedaserver.network.CambioApi
import com.example.appmonedaserver.repository.MonedaViewModel
import com.example.appmonedaserver.repository.MonedaViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val monedaViewModel: MonedaViewModel by  viewModels {
        MonedaViewModelFactory((application as MiApplication).repositoryMoneda)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        monedaViewModel.allMoneda.observe(this){
            it?.let {  ls ->
                ls.forEach { moneda ->
                    Log.d("ListaMoneda", "ID= ${moneda._ID}, code=${moneda.codeMoneda}" )
                }
            }
        }


        GlobalScope.launch {
            try {
                val response = CambioApi.retrofitService.getCambioApi()
                Log.d("API RESPONSE","VEAMOOOOOS")
                for ((key, value) in response.rates) {
                    println("Clave: $key Valor: $value")
                }
                println("Ultima actualización: ${response.time_last_update_utc}")
            } catch (e: Exception) {
                Log.d("TAG", "NOOOOOOOOOOOOO ${e}");

            }
        }





    }
}