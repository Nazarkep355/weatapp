package com.example.kotlinweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.doAsync
import org.json.JSONObject
import java.net.URL



private var et :EditText? = null
private var btn :Button? = null
private var Textview1: TextView? = null
private var Textview2: TextView? =null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.Button1)
        et = findViewById(R.id.City)
        Textview1 = findViewById(R.id.Info)
        Textview2 = findViewById(R.id.info2)
        var key:String="f14e98bd4da94970a8a132757210212"

        var city: String = "Kiev"
        var weather:String =""
        var temp:String = ""


            btn?.setOnClickListener {

if(et?.text?.toString()?.trim()?.equals("")!!)
{
    Toast.makeText(this,"Enter city, please",Toast.LENGTH_SHORT)
}else{
    city = et?.text.toString()
}
                    var url: String ="https://api.weatherapi.com/v1/current.json?key=f14e98bd4da94970a8a132757210212%20&q=$city&aqi=no"
                doAsync {
                    var apiResponse = URL(url).readText().toString()
                    temp = JSONObject(apiResponse).getJSONObject("current").getString("temp_c")
                    weather= JSONObject(apiResponse).getJSONObject("current").getJSONObject("condition").getString("text")
                    Textview1?.text = "Погода: $weather "
                           Textview2?.text = " Температура: $temp"

                }

        }
    }
}


