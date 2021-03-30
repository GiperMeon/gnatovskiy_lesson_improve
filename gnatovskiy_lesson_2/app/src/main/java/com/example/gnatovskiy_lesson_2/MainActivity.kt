package com.example.gnatovskiy_lesson_2

import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity (){
    private lateinit var buttonFirst : Button
    private lateinit var buttonSecond : Button

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        buttonFirst = findViewById(R.id.button_first)
        buttonFirst.setOnClickListener {
            val clickButton = Intent(this, FirstActivity::class.java)
            startActivity(clickButton)
        }
        buttonSecond = findViewById(R.id.button_second)
        buttonSecond.setOnClickListener {
            val clickButton = Intent(this, SecondActivity::class.java)
            startActivity(clickButton)
        }
    }
}