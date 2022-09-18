package com.centennial.jovichenmcintyre_mapd711_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.centennial.jovichenmcintyre_mapd711_task1.models.Student
import com.google.gson.Gson

class DisplayPersonInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_person_information)

        var serializedObject = intent.getStringExtra("person")
        var student = Gson().fromJson(serializedObject,Student::class.java)
        var textView = findViewById<TextView>(R.id.textView)
        textView.text = student.displayInfo(this)
    }
}