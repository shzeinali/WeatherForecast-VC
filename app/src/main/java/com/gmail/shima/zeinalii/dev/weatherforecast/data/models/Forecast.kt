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

    @field:SerializedName("feels_like")
    val feelsLike: FeelsLike,

    @field:SerializedName("pressure")
    val pressure: Int,

    @field:SerializedName("humidity")
    val humidity: Int,

    @field:SerializedName("weather")
    val weather: List<Weather>,

    @field:SerializedName("speed")
    val windSpeed: Float,

//    @field:SerializedName("deg")
//    val WindDirection: Int,
//
//    @field:SerializedName("gust")
//    val windGust: Float,
//
//    @field:SerializedName("clouds")
//    val cloudiness: Int,
//
//    @field:SerializedName("pop")
//    val probability: Float,
//
//    @field:SerializedName("rain")
//    val precipitationVolume: Float

) {

    fun firstItemOfWeather(): Weather {
        //NOTE: It is possible to meet more than one weather condition for a requested location.
        // The first weather condition in API respond is primary
        return weather[0]
    }

    fun dateStr(): String {
        val dateFormat = SimpleDateFormat("EEE MMM dd", Locale.ENGLISH)
        return dateFormat.format(date * 1000L)
    }

    fun sunriseStr(): String {
        val dateFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
        return dateFormat.format(sunrise * 1000L)
    }

    fun sunsetStr(): String {
        val dateFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
        return dateFormat.format(sunset * 1000L)
    }

    fun humidityStr(): String {
        return "$humidity%"
    }

    fun pressureStr(): String {
        return "$pressure In"
    }

    fun windSpeedStr(): String {
        return windSpeed.roundToInt().toString() + "km/h"
    }
}