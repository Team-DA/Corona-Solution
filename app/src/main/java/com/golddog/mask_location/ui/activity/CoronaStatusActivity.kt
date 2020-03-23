package com.golddog.mask_location.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.golddog.mask_location.R
import com.golddog.mask_location.base.BaseActivity
import com.golddog.mask_location.data.ApiClient
import com.golddog.mask_location.databinding.ActivityCoronaStatusBinding
import com.golddog.mask_location.viewmodel.CoronaStatusViewModel
import com.golddog.mask_location.viewmodelfactory.CoronaStatusViewModelFactory

class CoronaStatusActivity : BaseActivity<ActivityCoronaStatusBinding>() {
    override val layoutResourceId: Int = R.layout.activity_corona_status

    private lateinit var viewModel: CoronaStatusViewModel
    private lateinit var viewModelFactory: CoronaStatusViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelFactory = CoronaStatusViewModelFactory(ApiClient())
        viewModel = ViewModelProvider(this, viewModelFactory).get(CoronaStatusViewModel::class.java)

        binding.vm = viewModel
    }
}