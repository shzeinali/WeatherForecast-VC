package com.gmail.shima.zeinalii.dev.weatherforecast.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


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
    val sunset: Long
)