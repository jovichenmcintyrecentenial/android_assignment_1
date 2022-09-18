package com.centennial.jovichenmcintyre_mapd711_task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.centennial.jovichenmcintyre_mapd711_task1.exception.UserInputException
import com.centennial.jovichenmcintyre_mapd711_task1.models.Student
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    //declare edit text view
    private lateinit var nameEditText:EditText
    private lateinit var addressEditText:EditText
    private lateinit var occupationEditText:EditText
    private lateinit var dreamJobEditText:EditText
    private lateinit var favouriteFoodEditText:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize edit text views
        nameEditText = findViewById(R.id.name)
        addressEditText= findViewById(R.id.address)
        occupationEditText= findViewById(R.id.occupation)
        dreamJobEditText= findViewById(R.id.dream_job)
        favouriteFoodEditText= findViewById(R.id.favourite)
    }

    //use to display toast messages
    private fun showMessage(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    //validate edit text information
    private fun isDataValid(): Boolean {

        if(nameEditText.text.trim().isEmpty()){
            throw UserInputException("Please fill out the name field")
        }
        if(addressEditText.text.trim().isEmpty()){
            throw UserInputException("Please fill out the address field")
        }
        if(occupationEditText.text.trim().isEmpty()){
            throw UserInputException("Please fill out the profession field")
        }
        if(dreamJobEditText.text.trim().isEmpty()){
            throw UserInputException("Please enter your dream job")
        }
        if(favouriteFoodEditText.text.trim().isEmpty()){
            throw UserInputException("Please enter your favourite food")
        }

        return true
    }

    fun onSubmit(view: View) {
        try {
            //validate user input
            if (isDataValid()) {


                //create person object using data from text field
                var student = Student(
                    nameEditText.text.toString(),
                    addressEditText.text.toString(),
                    occupationEditText.text.toString(),
                    dreamJobEditText.text.toString(),
                    favouriteFoodEditText.text.toString(),

                )

                //serialize person object so it can be passed in intent as a JSON string
                var serializedData:String = Gson().toJson(student)

                //navigate to other intent with class data
                var intent = Intent(this,DisplayPersonInformationActivity::class.java)
                intent.putExtra("person",serializedData)
                startActivity(intent)
            }
        }
        //catch  and display user input exception
        catch (e: UserInputException) {
            //display exception message
            showMessage(e.message.toString())
        }
    }
}