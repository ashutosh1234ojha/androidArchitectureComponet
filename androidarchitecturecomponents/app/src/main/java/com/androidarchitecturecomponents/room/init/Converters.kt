package com.androidarchitecturecomponents.room.init

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Ashutosh Ojha on 2019-04-25.
 */
class Converters {

    @TypeConverter
    fun fromString(value: String): Person {
        val listType = object : TypeToken<Person>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromPerson(person: Person): String {
        val gson = Gson()
        return gson.toJson(person)
    }
}