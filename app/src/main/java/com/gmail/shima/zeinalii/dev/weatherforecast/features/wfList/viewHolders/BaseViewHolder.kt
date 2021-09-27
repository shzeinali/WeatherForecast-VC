package com.gmail.shima.zeinalii.dev.weatherforecast.features.wfList.viewHolders

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
abstract class BaseViewHolder<T>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T)
}