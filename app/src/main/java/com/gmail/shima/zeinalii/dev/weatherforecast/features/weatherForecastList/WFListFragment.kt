package com.gmail.shima.zeinalii.dev.weatherforecast.features.weatherForecastList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.FragmentWfListBinding
import com.gmail.shima.zeinalii.dev.weatherforecast.features.common.BaseFragment
import com.gmail.shima.zeinalii.dev.weatherforecast.viewmodels.WFListViewModel
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Result
import com.gmail.shima.zeinalii.dev.weatherforecast.features.common.hide
import com.gmail.shima.zeinalii.dev.weatherforecast.features.common.show
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@AndroidEntryPoint
class WFListFragment : BaseFragment() {
    private lateinit var binding: FragmentWfListBinding
    private val viewModel: WFListViewModel by viewModels()

    @Inject
    lateinit var adapter: WFListAdapter

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
        initAdapter()
        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.forecasts.observe(viewLifecycleOwner, { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    result.data?.let {
                        binding.progressBar.hide()
                        adapter.submitList(it)
                        handleEmptyListView(it.isEmpty())
                    }
                }
                Result.Status.LOADING -> {
                    binding.progressBar.show()
                }
                Result.Status.ERROR -> {
                    binding.progressBar.hide()
                }
            }
        })
    }

    private fun initAdapter() {
        binding.recyclerView.adapter = adapter
    }

    private fun handleEmptyListView(isEmpty: Boolean) {
        when (isEmpty) {
            true -> binding.groupEmptyListError.visibility = View.VISIBLE
            false -> binding.groupEmptyListError.visibility = View.GONE
        }
    }
}