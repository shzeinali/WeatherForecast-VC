package com.gmail.shima.zeinalii.dev.weatherforecast.data.dataSources

import com.gmail.shima.zeinalii.dev.weatherforecast.data.api.BaseDataSource
import com.gmail.shima.zeinalii.dev.weatherforecast.data.api.WFService
import javax.inject.Inject


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
class ForecastRemoteDS @Inject constructor(private val service: WFService) :
    BaseDataSource() {

    suspend fun fetchForecasts() = getResult {
        service.getForecasts(
            "Paris",
            "json",
            "metric",
            16,
            "648a3aac37935e5b45e09727df728ac2"
        )
    }
}