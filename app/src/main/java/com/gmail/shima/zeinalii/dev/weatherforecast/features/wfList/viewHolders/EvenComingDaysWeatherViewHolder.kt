package com.gmail.shima.zeinalii.dev.weatherforecast.features.wfList.viewHolders

import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Forecast
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.ItemEvenCominDaysWeatherBinding


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
class EvenComingDaysWeatherViewHolder(private val binding: ItemEvenCominDaysWeatherBinding) :
    BaseViewHolder<Forecast>(binding) {
    override fun bind(item: Forecast) {
        binding.apply {
            forecast = item
            executePendingBindings()
        }
    }

}