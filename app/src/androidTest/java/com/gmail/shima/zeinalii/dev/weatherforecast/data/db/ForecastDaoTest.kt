package com.gmail.shima.zeinalii.dev.weatherforecast.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.FeelsLike
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Forecast
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Temperature
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Weather
import com.gmail.shima.zeinalii.dev.weatherforecast.utilities.forecast1
import com.gmail.shima.zeinalii.dev.weatherforecast.utilities.forecast2
import com.gmail.shima.zeinalii.dev.weatherforecast.utilities.getValue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers
import org.junit.*
import org.junit.runner.RunWith


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@RunWith(AndroidJUnit4::class)
class ForecastDaoTest : WFDatabaseTest() {

    private lateinit var forecastDao: ForecastDao

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        forecastDao = db.forecastDao()
        runBlocking {
            forecastDao.insertForecasts(listOf(forecast1, forecast2))
        }
    }

    @Test
    fun getForecasts() {
        val forecasts = getValue(forecastDao.getForecasts())
        assertThat(forecasts.size, Matchers.equalTo(2))
    }

    @Test
    fun getForecast() = runBlocking {
        assertThat(forecastDao.getForecast(forecast1.id).first(), Matchers.equalTo(forecast1))
    }
}