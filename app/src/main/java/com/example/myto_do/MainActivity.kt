package com.example.myto_do

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val logo: ImageView =findViewById<ImageView>(R.id.logo)

        logo.setOnClickListener{
            val intent = Intent(this,DisplayNote::class.java)
            startActivity(intent)
        }
    }
}