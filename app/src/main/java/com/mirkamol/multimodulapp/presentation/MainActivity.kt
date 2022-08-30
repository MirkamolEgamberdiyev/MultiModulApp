package com.mirkamol.multimodulapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mirkamol.multimodulapp.App
import com.mirkamol.multimodulapp.R
import com.mirkamol.multimodulapp.viewModel.UserResource
import com.mirkamol.multimodulapp.viewModel.UserViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: UserViewModel by viewModels { factory }
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appCompanent.inject(this)
        setContentView(R.layout.activity_main)


        lifecycleScope.launch {
            viewModel.getUsers()
                .collect {

                    when (it) {
                        is UserResource.Error -> {
                        }
                        is UserResource.Succes -> {
                            Log.d(TAG, "onCreate: ${it.list}")
                        }
                        is UserResource.Loading -> {

                        }
                    }
                }
        }


    }
}