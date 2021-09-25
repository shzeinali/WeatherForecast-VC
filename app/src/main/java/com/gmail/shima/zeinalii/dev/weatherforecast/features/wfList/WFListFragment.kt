package com.gmail.shima.zeinalii.dev.weatherforecast.features.wfList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.FragmentWfListBinding
import com.gmail.shima.zeinalii.dev.weatherforecast.features.common.BaseFragment


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
class WFListFragment : BaseFragment() {
    private lateinit var binding: FragmentWfListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWfListBinding.inflate(inflater, container, false)
        return binding.root
    }

}