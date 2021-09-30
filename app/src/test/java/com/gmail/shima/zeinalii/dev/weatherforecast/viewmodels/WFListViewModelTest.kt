package com.gmail.shima.zeinalii.dev.weatherforecast.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gmail.shima.zeinalii.dev.weatherforecast.data.repositories.ForecastRepository
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */

@RunWith(JUnit4::class)
class WFListViewModelTest {

    private val forecastId = 1

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val repository = mock(ForecastRepository::class.java)
    private var viewModel = WFListViewModel(repository)

    @Test
    fun testNull() {
        verify(repository, never()).forecast(forecastId)
    }
}