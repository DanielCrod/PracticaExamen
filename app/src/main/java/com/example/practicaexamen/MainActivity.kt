package com.example.practicaexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var insertar : Button
    private lateinit var eliminar : Button
    private lateinit var descartar : Button
    private lateinit var buscar : Button
    private lateinit var mostrar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insertar = findViewById(R.id.insertar)
        eliminar = findViewById(R.id.eliminar)
        descartar = findViewById(R.id.descartar)
        buscar = findViewById(R.id.buscar)
        mostrar = findViewById(R.id.mostrar)

        insertar.setOnClickListener(this)
        eliminar.setOnClickListener(this)
        descartar.setOnClickListener(this)
        buscar.setOnClickListener(this)
        mostrar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

            R.id.insertar -> {
                val intent = Intent(this, InsertarActivity::class.java)
                startActivity(intent)
            }

            R.id.eliminar -> {
                val intent = Intent(this, EliminarActivity::class.java)
                startActivity(intent)
            }

            R.id.descartar -> {
                val intent = Intent(this, DescartarActivity::class.java)
                startActivity(intent)
            }

            R.id.buscar -> {
                val intent = Intent(this, BuscarActivity::class.java)
                startActivity(intent)
            }

            R.id.mostrar -> {
                val intent = Intent(this, MostrarActivity::class.java)
                startActivity(intent)
            }

        }
    }
}