package com.gmail.shima.zeinalii.dev.weatherforecast.features.wfList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Forecast
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.ItemEvenCominDaysWeatherBinding
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.ItemOddCominDaysWeatherBinding
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.ItemTodayWeatherBinding
import com.gmail.shima.zeinalii.dev.weatherforecast.features.wfList.viewHolders.BaseViewHolder
import com.gmail.shima.zeinalii.dev.weatherforecast.features.wfList.viewHolders.EvenComingDaysWeatherViewHolder
import com.gmail.shima.zeinalii.dev.weatherforecast.features.wfList.viewHolders.OddComingDaysWeatherViewHolder
import com.gmail.shima.zeinalii.dev.weatherforecast.features.wfList.viewHolders.TodayWeatherViewHolder
import javax.inject.Inject


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
class WFListAdapter @Inject constructor() :
    ListAdapter<Forecast, BaseViewHolder<Forecast>>(DiffCallback()) {

    companion object {
        private const val TYPE_TODAY_WEATHER = 0
        private const val TYPE_ODD_COMING_DAYS = 1
        private const val TYPE_EVEN_COMING_DAYS = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Forecast> {
        when (viewType) {
            TYPE_TODAY_WEATHER -> {
                return TodayWeatherViewHolder(
                    ItemTodayWeatherBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            TYPE_ODD_COMING_DAYS -> {
                return OddComingDaysWeatherViewHolder(
                    ItemOddCominDaysWeatherBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            TYPE_EVEN_COMING_DAYS -> {
                return EvenComingDaysWeatherViewHolder(
                    ItemEvenCominDaysWeatherBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Forecast>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            position == 0 -> TYPE_TODAY_WEATHER
            position.mod(2) == 0 -> TYPE_EVEN_COMING_DAYS
            else -> TYPE_ODD_COMING_DAYS
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Forecast>() {

    override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem == newItem
    }
}