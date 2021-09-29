package com.gmail.shima.zeinalii.dev.weatherforecast.data.models

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
data class Temperature(
    @field:SerializedName("min")
    val min: Float,

    @field:SerializedName("max")
    val max: Float,

    @field:SerializedName("day")
    val day: Float,

    @field:SerializedName("night")
    val night: Float,

    @field:SerializedName("eve")
    val evening: Float,

    @field:SerializedName("morn")
    val morning: Float
) {
    fun minMaxTempStr(): String {
        return max.roundToInt().toString() + 0x00B0.toChar() +
                " / " + min.roundToInt().toString() + 0x00B0.toChar()
    }

    fun minStr(): String {
        return min.roundToInt().toString() + 0x00B0.toChar()
    }

    fun maxStr(): String {
        return max.roundToInt().toString() + 0x00B0.toChar()
    }

    fun tempInt(): Int {
        return currentTemp().roundToInt()
    }

    private fun currentTemp(): Float {
        val tsLong = System.currentTimeMillis() / 1000
        val dateFormat = SimpleDateFormat("HH", Locale.ENGLISH)
        return when (dateFormat.format(tsLong * 1000L).toInt()) {
            in 5..11 -> morning
            in 12..16 -> day
            in 17..20 -> evening
            in 21..24 -> night
            in 0..4 -> night
            else -> throw IllegalArgumentException("Invalid time")
        }
    }

    fun currentTempStr(): String {
        return currentTemp().roundToInt().toString() + 0x00B0.toChar()
    }

    fun weatherStatus(): String {
        val t = currentTemp().roundToInt()
        return when {
            t > 25 -> "A hot day!"
            t < 10 -> "A cold day!"
            else -> "A grate day!"
        }
    }
}