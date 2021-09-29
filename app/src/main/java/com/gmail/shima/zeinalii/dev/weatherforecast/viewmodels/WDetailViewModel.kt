package com.gmail.shima.zeinalii.dev.weatherforecast.viewmodels

import androidx.lifecycle.*
import com.gmail.shima.zeinalii.dev.weatherforecast.data.repositories.ForecastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@HiltViewModel
class WDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repository: ForecastRepository
) :
    ViewModel() {


    private val forecastId: Int = savedStateHandle.get<Int>(FORECAST_ID_SAVED_STATE_KEY)!!

    val forecast = repository.forecast(forecastId).asLiveData()


    companion object {
        private const val FORECAST_ID_SAVED_STATE_KEY = "forecastId"
    }
}