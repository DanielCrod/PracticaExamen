package com.example.practicaexamen

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaexamen.SQL.SqliteHelper

class EliminarActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener,
    View.OnClickListener {

    private lateinit var seekBar: SeekBar
    private lateinit var list: ListView
    private lateinit var txt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar)

        seekBar = findViewById(R.id.seekBar)
        list = findViewById(R.id.list)
        txt = findViewById(R.id.txt)

        seekBar.setOnSeekBarChangeListener(this)
        seekBar.setOnClickListener(this)

        val helper = SqliteHelper(this)
        val nombres = helper.leerNombres()

        val arrayNombres = ArrayList<String>()
        val cursorNombres = helper.leerNombres()
        while (cursorNombres.moveToNext()) {
            arrayNombres.add(
                cursorNombres.getString(cursorNombres.getColumnIndexOrThrow(PersonasContract.NOMBRE))
            )
        }

        val adaptadorPersona = ArrayAdapter (this,
        android.R.layout.simple_list_item_1, arrayNombres)

        list.adapter = adaptadorPersona
        seekBar.setMax(100)


    }



    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        txt.setText("" + progress)
        val helper = SqliteHelper(this)
        helper.filtrar(txt.toString().toInt())
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}