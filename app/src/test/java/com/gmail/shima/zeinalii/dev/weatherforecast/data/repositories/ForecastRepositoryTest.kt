package com.gmail.shima.zeinalii.dev.weatherforecast.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gmail.shima.zeinalii.dev.weatherforecast.data.api.WFService
import com.gmail.shima.zeinalii.dev.weatherforecast.data.dataSources.ForecastRemoteDS
import com.gmail.shima.zeinalii.dev.weatherforecast.data.db.ForecastDao
import com.gmail.shima.zeinalii.dev.weatherforecast.data.db.WFDatabase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mockito


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@RunWith(JUnit4::class)
class ForecastRepositoryTest {

    private lateinit var repository: ForecastRepository
    private val dao = Mockito.mock(ForecastDao::class.java)
    private val service = Mockito.mock(WFService::class.java)
    private val remoteDataSource = ForecastRemoteDS(service)

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        val db = Mockito.mock(WFDatabase::class.java)
        Mockito.`when`(db.forecastDao()).thenReturn(dao)
        Mockito.`when`(db.runInTransaction(ArgumentMatchers.any())).thenCallRealMethod()
        repository = ForecastRepository(dao, remoteDataSource)
    }

    @Test
    fun loadForecastsFromNetwork() {
        runBlocking {
            repository.forecasts

            Mockito.verify(dao, Mockito.never()).getForecasts()
            Mockito.verifyZeroInteractions(dao)
        }
    }
}