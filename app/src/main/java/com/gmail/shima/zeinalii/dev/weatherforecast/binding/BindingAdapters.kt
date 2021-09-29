package com.gmail.shima.zeinalii.dev.weatherforecast.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gmail.shima.zeinalii.dev.weatherforecast.R


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    Glide.with(view.context)
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}

@BindingAdapter("headerImage")
fun bindheaderImage(view: ImageView, temp: Int) {
    when {
        temp > 25 -> view.setImageResource(R.drawable.hot)
        temp < 10 -> view.setImageResource(R.drawable.cold)
        else -> view.setImageResource(R.drawable.normal)
    }
}

@BindingAdapter("imageFromDrawable")
fun bindImageFromRes(view: ImageView, imageRes: Drawable?) {
    view.setImageDrawable(imageRes)
}