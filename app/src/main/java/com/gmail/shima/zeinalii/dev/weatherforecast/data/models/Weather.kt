package com.gmail.shima.zeinalii.dev.weatherforecast.data.models

import com.google.gson.annotations.SerializedName


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
data class Weather(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("main")
    val main: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("icon")
    val icon: String,

    ) {

    fun iconUrl2x(): String {
        return "https://openweathermap.org/img/wn/$icon@2x.png"
    }

    fun iconUrl4x(): String {
        return "https://openweathermap.org/img/wn/$icon@4x.png"
    }

    fun mainDescriptionStr(): String {
        return "$main - $description"
    }
}
