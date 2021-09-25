package com.gmail.shima.zeinalii.dev.weatherforecast.data.api

import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.WFStatus
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
interface WFService {

    @GET("forecast/daily")
    suspend fun getForecasts(
        @Query("q") cityName: String,
        @Query("mode") mode: String,
        @Query("units") units: String,
        @Query("cnt") count: Int,
        @Query("appid") appId: String
    ): Response<WFStatus>
}