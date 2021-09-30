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
        @Query("q") cityName: String? = null,
        @Query("mode") mode: String? = null,
        @Query("units") units: String? = null,
        @Query("cnt") count: Int? = null,
        @Query("appid") appId: String? = null
    ): Response<WFStatus>
}