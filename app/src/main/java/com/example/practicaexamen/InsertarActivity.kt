package com.example.practicaexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.practicaexamen.SQL.SqliteHelper

class InsertarActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var numero : EditText
    private lateinit var nombre : EditText
    private lateinit var apellido : EditText
    private lateinit var altura : EditText
    private lateinit var edad : EditText
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar)

        numero = findViewById(R.id.numero)
        nombre = findViewById(R.id.nombre)
        apellido = findViewById(R.id.apellido)
        altura = findViewById(R.id.altura)
        edad = findViewById(R.id.edad)
        button = findViewById(R.id.insertar)

        button.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.insertar -> {
                try {
                    val helper = SqliteHelper(this)
                    val persona = Persona (numero.text.toString().toInt(), nombre.text.toString(), apellido.text.toString(), altura.text.toString().toDouble(), edad.text.toString().toInt())
                    helper.insertar(persona)
                    Toast.makeText(this, "Insertado!", Toast.LENGTH_SHORT).show()
                    numero.setText("")
                    nombre.setText("")
                    apellido.setText("")
                    altura.setText("")
                    edad.setText("")
                }catch (e : java.lang.Exception) {
                    Toast.makeText(this, "No se pudo insertar correctamente", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}