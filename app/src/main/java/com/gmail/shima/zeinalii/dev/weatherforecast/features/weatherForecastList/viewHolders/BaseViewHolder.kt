package com.gmail.shima.zeinalii.dev.weatherforecast.features.weatherForecastList.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
abstract class BaseViewHolder<T>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T, listener: View.OnClickListener)
}