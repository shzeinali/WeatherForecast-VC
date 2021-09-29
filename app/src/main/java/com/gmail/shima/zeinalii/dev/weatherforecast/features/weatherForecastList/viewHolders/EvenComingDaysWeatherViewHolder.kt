package com.gmail.shima.zeinalii.dev.weatherforecast.features.weatherForecastList.viewHolders

import android.view.View
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Forecast
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.ItemEvenCominDaysWeatherBinding


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
class EvenComingDaysWeatherViewHolder(private val binding: ItemEvenCominDaysWeatherBinding) :
    BaseViewHolder<Forecast>(binding) {
    override fun bind(item: Forecast, listener: View.OnClickListener) {
        binding.apply {
            clickListener = listener
            forecast = item
            executePendingBindings()
        }
    }

}