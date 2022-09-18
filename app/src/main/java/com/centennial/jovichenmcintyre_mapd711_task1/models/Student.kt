package com.centennial.jovichenmcintyre_mapd711_task1.models

import android.content.Context
import android.content.res.Resources
import com.centennial.jovichenmcintyre_mapd711_task1.R

class Student(
    name: String,
    address: String,
    profession: String,
    dreamJob: String,
    favouriteFood: String
) {
    var name:String = name
    var address: String = address
    var profession: String = profession
    var dreamJob: String = dreamJob
    var favouriteFood: String = favouriteFood

    fun displayInfo(context: Context): String {

        var str = ""
        str+=context.getString(R.string.name)+": $name\n"
        str+=context.getString(R.string.address)+": $address\n"
        str+=context.getString(R.string.profession)+": $profession\n"
        str+=context.getString(R.string.dream_job)+": $dreamJob\n"
        str+=context.getString(R.string.favourite_food)+": $favouriteFood\n"
        return str
    }

}