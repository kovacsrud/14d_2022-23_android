package com.raz.speed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.time.Duration

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inputSebesseg:EditText=findViewById(R.id.inputSebesseg);
        var eredmeny:TextView=findViewById(R.id.eredmeny);
        var gomb:Button=findViewById(R.id.szamoloGomb);
        var msSebesseg=0.0

        gomb.setOnClickListener{
            try {
                var aktSebesseg=inputSebesseg.text.toString().toFloat()
                msSebesseg=aktSebesseg/3.6
                eredmeny.text=msSebesseg.toString()
                Log.i("Eredmény",eredmeny.text.toString())
                Toast.makeText(this,eredmeny.text.toString(),Toast.LENGTH_LONG).show()
            } catch (e:Exception){
                Log.e("Hiba",e.message.toString())

            }


        }

    }
}