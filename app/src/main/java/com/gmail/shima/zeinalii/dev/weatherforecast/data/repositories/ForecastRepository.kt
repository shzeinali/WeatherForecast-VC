package com.gmail.shima.zeinalii.dev.weatherforecast.data.repositories

import com.gmail.shima.zeinalii.dev.weatherforecast.data.api.resultLiveData
import com.gmail.shima.zeinalii.dev.weatherforecast.data.db.ForecastDao
import com.gmail.shima.zeinalii.dev.weatherforecast.data.dataSources.ForecastRemoteDS
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */

@Singleton
class ForecastRepository @Inject constructor(
    private val dao: ForecastDao,
    private val remoteSource: ForecastRemoteDS
) {

    val forecasts = resultLiveData(
        databaseQuery = { dao.getForecasts() },
        networkCall = { remoteSource.fetchForecasts() },
        deleteOldData = { dao.deleteForecasts() },
        saveCallResult = { dao.insertForecasts(it.forecasts) })

    fun forecast(forecastId: Int) = dao.getForecast(forecastId)
}