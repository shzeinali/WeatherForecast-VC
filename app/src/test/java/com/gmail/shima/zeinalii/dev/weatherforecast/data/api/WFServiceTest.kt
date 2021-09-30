package com.gmail.shima.zeinalii.dev.weatherforecast.data.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Temperature
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */

@RunWith(JUnit4::class)
class WFServiceTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var service: WFService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun createService() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WFService::class.java)
    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
    }

    @Test
    fun requestForecasts() {
        runBlocking {
            enqueueResponse("forecasts.json")
            val resultResponse = service.getForecasts().body()

            val request = mockWebServer.takeRequest()
            assertNotNull(resultResponse)
            assertThat(request.path, `is`("/forecast/daily"))
        }
    }

    @Test
    fun getForecastResponse() {
        runBlocking {
            enqueueResponse("forecasts.json")
            val resultResponse = service.getForecasts().body()
            val forecasts = resultResponse!!.forecasts

            assertThat(resultResponse.count, `is`(16))
            assertThat(forecasts.size, `is`(16))
        }
    }

    @Test
    fun getForecast() {
        runBlocking {
            enqueueResponse("forecasts.json")
            val resultResponse = service.getForecasts().body()
            val forecasts = resultResponse!!.forecasts
            val temp = Temperature(6.12f, 17.88f, 15.8f, 14.18f, 16.77f, 6.85f)

            val forecast = forecasts[0]
            assertThat(forecast.date, `is`(1632999600))
            assertThat(forecast.sunrise, `is`(1632980916))
            assertThat(forecast.sunset, `is`(1633023143))
            assertThat(forecast.temp, `is`(temp))
        }
    }

    private fun enqueueResponse(fileName: String, headers: Map<String, String> = emptyMap()) {
        val inputStream = javaClass.classLoader
            .getResourceAsStream("api-response/$fileName")
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        mockWebServer.enqueue(
            mockResponse.setBody(
                source.readString(Charsets.UTF_8)
            )
        )
    }
}