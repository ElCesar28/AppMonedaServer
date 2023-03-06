package com.example.appmonedaserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.appmonedaserver.repository.CambioViewModel
import com.example.appmonedaserver.repository.CambioViewModelFactory
import com.example.appmonedaserver.repository.MonedaViewModel
import com.example.appmonedaserver.repository.MonedaViewModelFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}