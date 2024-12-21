package com.kubilaygurel.weatherapp.presentaion

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.kubilaygurel.weatherapp.presentaion.screen.WeatherScreen
import com.kubilaygurel.weatherapp.presentaion.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupPermissionLauncher()
        requestPermissions()
        enableEdgeToEdge()
        setContent {
            WeatherScreen(viewModel = viewModel, permissionLauncher = permissionLauncher)
        }
    }

    private fun setupPermissionLauncher(){
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){ permissions ->
            val allPermissionsGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true &&
                    permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
            if (allPermissionsGranted){
                viewModel.loadWeatherInfo()
            } else{
                viewModel.updatePermissionDenied(true)
            }
        }

    }

    private fun requestPermissions(){
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }
                }

