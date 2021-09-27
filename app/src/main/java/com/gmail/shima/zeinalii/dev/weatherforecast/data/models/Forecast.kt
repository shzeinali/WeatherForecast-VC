package com.gmail.shima.zeinalii.dev.weatherforecast.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@Entity(tableName = "forecasts")
data class Forecast(
    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("dt")
    val date: Long,

    @field:SerializedName("sunrise")
    val sunrise: Long,

    @field:SerializedName("sunset")
    val sunset: Long,

    @field:SerializedName("temp")
    val temp: Temperature,

    @field:SerializedName("weather")
    val weather: List<Weather>

) {

    fun firstItemOfWeather(): Weather {
        //NOTE: It is possible to meet more than one weather condition for a requested location.
        // The first weather condition in API respond is primary
        return weather[0]
    }

    fun dateString(): String {
        val dateFormat = SimpleDateFormat("EEE MMM dd", Locale.ENGLISH)
        return dateFormat.format(date * 1000L)
    }
}