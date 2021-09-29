package com.gmail.shima.zeinalii.dev.weatherforecast.features.weatherDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.gmail.shima.zeinalii.dev.weatherforecast.databinding.FragmentWDetailBinding
import com.gmail.shima.zeinalii.dev.weatherforecast.features.common.BaseFragment
import com.gmail.shima.zeinalii.dev.weatherforecast.viewmodels.WDetailViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@AndroidEntryPoint
class WDetailFragment : BaseFragment() {
    private lateinit var binding: FragmentWDetailBinding
    private val viewModel: WDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)

        viewModel.forecast.observe(viewLifecycleOwner, {
            binding.apply {
                forecast = it
            }
        })
    }


    private fun initView(view: View) {
        var isToolbarShown = false
        // scroll change listener begins at Y = 0 when image is fully collapsed
        binding.scrollview.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->

                // User scrolled past image to height of toolbar and the title text is
                // underneath the toolbar, so the toolbar should be shown.
                val shouldShowToolbar = scrollY > binding.toolbar.height

                // The new state of the toolbar differs from the previous state; update
                // appbar and toolbar attributes.
                if (isToolbarShown != shouldShowToolbar) {
                    isToolbarShown = shouldShowToolbar

                    // Use shadow animator to add elevation if toolbar is shown
                    binding.appbar.isActivated = shouldShowToolbar

                    // Show the product name if toolbar is shown
                    binding.toolbarLayout.isTitleEnabled = shouldShowToolbar
                }
            }
        )
        binding.toolbar.setNavigationOnClickListener {
            view.findNavController().navigateUp()
        }
    }
}