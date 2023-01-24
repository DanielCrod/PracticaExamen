package com.example.practicaexamen

import android.provider.BaseColumns

object PersonasContract : BaseColumns{
    const val TABLE_NAME = "Personas"
    const val NUMERO = "numero"
    const val NOMBRE = "nombre"
    const val APELLIDO = "apellido"
    const val ALTURA = "altura"
    const val EDAD = "edad"
}