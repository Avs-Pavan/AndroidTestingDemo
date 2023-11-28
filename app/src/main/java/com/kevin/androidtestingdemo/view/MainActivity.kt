package com.kevin.androidtestingdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.kevin.androidtestingdemo.viewmodel.NewsViewModel
import com.kevin.androidtestingdemo.R
import com.kevin.androidtestingdemo.databinding.ActivityMainBinding
import com.kevin.androidtestingdemo.util.network.APIResponse
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initViews()

    }

    private fun initViews() {

        viewModel.quotationLiveData.observe(this) { data ->

            when (data) {
                is APIResponse.Loading -> {
//                    Log.e("tag", "loading")
//                    binding.loading.show()
                }

                is APIResponse.OnError -> {
//                    binding.loading.hide()
                    Toast.makeText(this, data.error, Toast.LENGTH_LONG).show()
                }

                is APIResponse.OnSuccess -> {
//                    binding.loading.hide()
//                    binding.tv.text = data.data?.quote
                }

                else -> {
                    // do noting
                }
            }
        }

//
//        binding.refreshBtn.setOnClickListener {
//            viewModel.getQuotation()
//        }
    }
}