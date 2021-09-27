package com.gmail.shima.zeinalii.dev.weatherforecast.data.models

import com.google.gson.annotations.SerializedName


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
data class WFStatus(
    @field:SerializedName("city")
    val city: City,
    @field:SerializedName("cod")
    val code: String,
    @field:SerializedName("cnt")
    val count: Int,
    @field:SerializedName("list")
    val forecasts: List<Forecast>,
)
