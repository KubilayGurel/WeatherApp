package com.kubilaygurel.weatherapp.presentaion

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kubilaygurel.weatherapp.presentaion.ui.WeatherForecast
import com.kubilaygurel.weatherapp.presentaion.ui.theme.CustomBackGround
import com.kubilaygurel.weatherapp.presentaion.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {

                Column (
                    modifier = Modifier.
                    fillMaxSize()
                        .background(CustomBackGround)
                ){
                    WeatherCard(state = viewModel.state)
                    Spacer(modifier = Modifier.height(10.dp))
                    WeatherForecast(state = viewModel.state)
                }

                }
            }
        }


    }