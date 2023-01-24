package com.example.practicaexamen.SQL

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.VERSION
import com.example.practicaexamen.Persona
import com.example.practicaexamen.PersonasContract

open class SqliteHelper (context: Context) :
 SQLiteOpenHelper(context, NAME, null, VERSION){

    companion object {
        private const val NAME = "Personas.db"
        private const val VERSION = 1
    }



    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL(
            "CREATE TABLE " +
                    PersonasContract.TABLE_NAME + " ( "
                    + PersonasContract.NUMERO + " INTEGER PRIMARY KEY, "
                    + PersonasContract.NOMBRE + " TEXT NULL, "
                    + PersonasContract.APELLIDO + " TEXT NULL, "
                    + PersonasContract.ALTURA + " DOUBLE NULL, "
                    + PersonasContract.EDAD + " INTEGER NULL);"
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertar(persona: Persona): Long {
        val db = writableDatabase
        val values = ContentValues()
        values.put(PersonasContract.NUMERO, persona.numero)
        values.put(PersonasContract.NOMBRE, persona.nombre)
        values.put(PersonasContract.APELLIDO, persona.apellido)
        values.put(PersonasContract.ALTURA, persona.altura)
        values.put(PersonasContract.EDAD, persona.edad)

        return db.insert(PersonasContract.TABLE_NAME, null, values)
    }

    fun leerNombres (): android.database.Cursor {
        val db = writableDatabase
        var nombres : android.database.Cursor =
            db.rawQuery("SELECT nombre FROM " + PersonasContract.TABLE_NAME + "", null)
        return nombres
    }

    fun filtrar (edad : Int): android.database.Cursor {
        val db = writableDatabase
        var nombres : android.database.Cursor =
            db.rawQuery("SELECT nombre FROM " + PersonasContract.TABLE_NAME + " WHERE edad = " + edad, null)
        return nombres
    }
}