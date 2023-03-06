package com.example.appmonedaserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.appmonedaserver.repository.MonedaViewModel
import com.example.appmonedaserver.repository.MonedaViewModelFactory


class MainActivity : AppCompatActivity() {
    private val monedaViewModel: MonedaViewModel by  viewModels {
        MonedaViewModelFactory((application as MiApplication).repositoryMoneda)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        monedaViewModel.allMoneda.observe(this){
//            it?.let {  ls ->
//                ls.forEach { moneda ->
//                    Log.d("ListaMoneda", "ID= ${moneda._ID}, code=${moneda.codeMoneda}" )
//                }
//            }
//        }

    }
}