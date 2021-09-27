package com.gmail.shima.zeinalii.dev.weatherforecast.features.wfList.viewHolders

import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Forecast
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.ItemTodayWeatherBinding


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
class TodayWeatherViewHolder(private val binding: ItemTodayWeatherBinding) :
    BaseViewHolder<Forecast>(binding) {
    override fun bind(item: Forecast) {
        binding.apply {
            forecast = item
            executePendingBindings()
        }
    }

}