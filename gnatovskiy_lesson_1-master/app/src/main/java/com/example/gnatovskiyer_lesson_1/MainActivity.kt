package com.example.gnatovskiyer_lesson_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var firstTaskButton: Button
    private lateinit var secondTaskButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        firstTaskButton = findViewById(R.id.buttonFirstTask)
        firstTaskButton.setOnClickListener {
            val clickButton = Intent(this, FirstTaskActivity::class.java)
            startActivity(clickButton)
        }
        secondTaskButton = findViewById(R.id.buttonSecondTask)
        secondTaskButton.setOnClickListener {
            val clickButton = Intent(this, SecondTaskActivity::class.java)
            startActivity(clickButton)
        }
    }
}