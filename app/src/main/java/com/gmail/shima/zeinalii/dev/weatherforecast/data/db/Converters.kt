package com.gmail.shima.zeinalii.dev.weatherforecast.data.db

import androidx.room.TypeConverter
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Temperature
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Weather
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
class Converters {

    @TypeConverter
    fun tempToJson(temp: Temperature): String = Gson().toJson(temp)

    @TypeConverter
    fun jsonToTemp(json: String): Temperature = Gson().fromJson(json, Temperature::class.java)

    @TypeConverter
    fun weatherToJson(weather: List<Weather>): String = Gson().toJson(weather)

    @TypeConverter
    fun jsonToWeather(json: String): List<Weather> {
        val type = object : TypeToken<List<Weather>>() {}.type
        return Gson().fromJson(json, type)
    }
}