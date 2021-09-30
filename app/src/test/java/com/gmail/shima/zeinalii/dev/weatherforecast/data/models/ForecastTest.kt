package com.gmail.shima.zeinalii.dev.weatherforecast.data.models

import org.junit.Assert
import org.junit.Before
import org.junit.Test


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
class ForecastTest {
    private lateinit var forecast: Forecast
    private lateinit var temp: Temperature
    private lateinit var weather: Weather
    private lateinit var feelsLike: FeelsLike

    @Before
    fun setUp() {
        temp = Temperature(10.0f, 21.0f, 19.0f, 8.0f, 10.0f, 12.0f)
        weather = Weather(500, "Rain", "light rain", "10d")
        feelsLike = FeelsLike(14.45f, 12.88f, 15.47f, 6.09f)
        forecast = Forecast(
            1,
            1632999600,
            1632980916,
            1633023143,
            temp,
            feelsLike,
            1028,
            39,
            listOf(weather),
            3.96f
        )
    }

    @Test
    fun dateStr() {
        Assert.assertEquals(forecast.dateStr(), "Thu Sep 30")
    }

    @Test
    fun sunriseStr() {
        Assert.assertEquals(forecast.sunriseStr(), "09:18 AM")
    }

    @Test
    fun windSpeedStr() {
        Assert.assertEquals(forecast.windSpeedStr(), "4km/h")
    }
}