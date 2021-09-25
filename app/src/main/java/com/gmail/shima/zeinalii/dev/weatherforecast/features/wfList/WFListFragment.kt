package com.gmail.shima.zeinalii.dev.weatherforecast.features.wfList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.FragmentWfListBinding
import com.gmail.shima.zeinalii.dev.weatherforecast.features.common.BaseFragment
import com.gmail.shima.zeinalii.dev.weatherforecast.viewmodels.WFListViewModel
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Result
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@AndroidEntryPoint
class WFListFragment : BaseFragment() {
    private lateinit var binding: FragmentWfListBinding
    private val viewModel: WFListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWfListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.forecasts.observe(viewLifecycleOwner, { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    result.data?.let {}
                }
                Result.Status.LOADING -> {
                }
                Result.Status.ERROR -> {
                }
            }
        })
    }
}