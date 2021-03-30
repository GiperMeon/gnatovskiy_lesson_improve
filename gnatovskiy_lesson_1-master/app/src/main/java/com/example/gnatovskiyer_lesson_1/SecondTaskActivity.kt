package com.example.gnatovskiyer_lesson_1

import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.gnatovskiyer_lesson_1.data.Students
import java.time.Year

class SecondTaskActivity : AppCompatActivity() {
    private val students : ArrayList<Students> = arrayListOf()
    private lateinit var  editStudents : EditText
    private lateinit var buttonViewStudents : Button
    private lateinit var viewId : TextView
    private lateinit var  viewName : TextView
    private lateinit var  viewSurname : TextView
    private lateinit var  viewGrade : TextView
    private lateinit var  viewYear : TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        editStudents = findViewById(R.id.edit_text_student)
        buttonViewStudents = findViewById(R.id.button_View_student)
        viewId = findViewById(R.id.view_id_student)
        viewName = findViewById(R.id.view_name_student)
        viewSurname = findViewById(R.id.view_surname_student)
        viewGrade = findViewById(R.id.view_grade_student)
        viewYear = findViewById(R.id.view_birthday_year)
        editStudents.setOnKeyListener(View.OnKeyListener { v, keyCode, keyEvent ->
            if(keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.action == KeyEvent.ACTION_UP){
                val data = editStudents.getText().toString().split(" ")
                if (data.size == 5){
                    val student = Students(data[0].toInt(), data[1], data[2], data[3], Year.of(data[4].toInt()) )
                    students.add(student)
                    editStudents.setText("")
                } else { Toast.makeText(this, "Ошибка! Неверный формат записи", Toast.LENGTH_SHORT).show() }
                return@OnKeyListener true
            }
            false
        })

        buttonViewStudents.setOnClickListener{
            viewId.setText("")
            viewName.setText("")
            viewSurname.setText("")
            viewGrade.setText("")
            viewYear.setText("")
            for (study in students){
                viewId.append(study.id.toString() + "\n")
                viewName.append(study.name + "\n")
                viewSurname.append(study.surname + "\n")
                viewGrade.append(study.grade + "\n")
                viewYear.append(study.birthdayYear.toString() + "\n")
            }
        }
    }
}