package com.gmail.shima.zeinalii.dev.weatherforecast.data.models

import com.google.gson.annotations.SerializedName


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
data class City(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("country")
    val country: String
)
