package com.gmail.shima.zeinalii.dev.weatherforecast.data.models

import com.google.gson.annotations.SerializedName
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

    fun tempStr(): String {
        return day.roundToInt().toString() + 0x00B0.toChar()
    }
}