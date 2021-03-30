package com.example.gnatovskiyer_lesson_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class FirstTaskActivity :AppCompatActivity() {
    private val students : TreeSet<String> = TreeSet()
    private lateinit var saveButton: Button
    private lateinit var viewButton: Button
    private lateinit var editText: EditText
    private lateinit var viewText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)
        editText = findViewById(R.id.edit_text_name)
        saveButton = findViewById(R.id.buttonSave)
        saveButton.setOnClickListener {
            if (editText.getText().isNotEmpty()){
                students.add(editText.getText().toString())
                editText.setText("")
            } else { Toast.makeText(this, "Заполните поле!", Toast.LENGTH_SHORT).show() }
        }

        viewText = findViewById(R.id.view_text_name)
        viewButton = findViewById(R.id.buttonView)
        viewButton.setOnClickListener {
            viewText.setText(students.joinToString("\n" ))
        }
    }
}