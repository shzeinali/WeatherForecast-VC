package com.gmail.shima.zeinalii.dev.weatherforecast.viewmodels

import androidx.lifecycle.ViewModel
import com.gmail.shima.zeinalii.dev.weatherforecast.data.repositories.ForecastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@HiltViewModel
class WFListViewModel @Inject constructor(repository: ForecastRepository) :
    ViewModel() {

    val forecasts = repository.forecasts
}