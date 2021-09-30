package com.gmail.shima.zeinalii.dev.weatherforecast.utilities

import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.FeelsLike
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Forecast
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Temperature
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Weather


val temp = Temperature(10.0f, 21.0f, 19.0f, 8.0f, 10.0f, 12.0f)
val weather = Weather(500, "Rain", "light rain", "10d")
val feelsLike = FeelsLike(14.45f, 12.88f, 15.47f, 6.09f)
val forecast1 = Forecast(
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
val forecast2 = Forecast(
    2,
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
