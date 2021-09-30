package com.gmail.shima.zeinalii.dev.weatherforecast.data.db

import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.FeelsLike
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Temperature
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Weather
import org.junit.Assert
import org.junit.Test


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
class ConvertersTest {

    private val temp = Temperature(10.0f, 21.0f, 19.0f, 8.0f, 10.0f, 12.0f)
    private val weather = Weather(500, "Rain", "light rain", "10d")
    private val feelsLike = FeelsLike(14.45f, 12.88f, 15.47f, 6.09f)

    private val tempJsonStr: String =
        "{\"min\":10.0,\"max\":21.0,\"day\":19.0,\"night\":8.0,\"eve\":10.0,\"morn\":12.0}"
    private val weatherJsonStr: String =
        "[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}]"
    private val feelsLikeJsonStr: String =
        "{\"day\":14.45,\"night\":12.88,\"eve\":15.47,\"morn\":6.09}"

    @Test
    fun tempToJson() {
        Assert.assertEquals(tempJsonStr, Converters().tempToJson(temp))
    }

    @Test
    fun jsonToTemp() {
        Assert.assertEquals(Converters().jsonToTemp(tempJsonStr), temp)
    }

    @Test
    fun weatherToJson() {
        Assert.assertEquals(weatherJsonStr, Converters().weatherToJson(listOf(weather)))
    }

    @Test
    fun jsonToWeather() {
        Assert.assertEquals(Converters().jsonToWeather(weatherJsonStr), listOf(weather))
    }

    @Test
    fun feelsLikeToJson() {
        Assert.assertEquals(feelsLikeJsonStr, Converters().feelsLikeToJson(feelsLike))
    }

    @Test
    fun jsonToFeelsLike() {
        Assert.assertEquals(Converters().jsonToFeelsLike(feelsLikeJsonStr), feelsLike)
    }

}