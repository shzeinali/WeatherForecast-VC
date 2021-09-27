package com.gmail.shima.zeinalii.dev.weatherforecast.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.gmail.shima.zeinalii.dev.weatherforecast.R
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.ActivityWfMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WFMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityWfMainBinding>(this, R.layout.activity_wf_main)
    }
}