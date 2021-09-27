package com.gmail.shima.zeinalii.dev.weatherforecast.features.common

import android.view.View
import android.widget.ProgressBar


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
fun ProgressBar.hide() {
    visibility = View.GONE
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

