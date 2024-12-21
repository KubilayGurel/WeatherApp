package com.kubilaygurel.weatherapp.presentaion.screen

import android.Manifest
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kubilaygurel.weatherapp.presentaion.compenents.ErrorContent
import com.kubilaygurel.weatherapp.presentaion.compenents.LoadingIndicator
import com.kubilaygurel.weatherapp.presentaion.compenents.WeatherCard
import com.kubilaygurel.weatherapp.presentaion.compenents.WeatherForecast
import com.kubilaygurel.weatherapp.presentaion.ui.theme.CustomBackGround
import com.kubilaygurel.weatherapp.presentaion.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel,
    permissionLauncher: ActivityResultLauncher<Array<String>>
){
    val state = viewModel.state

    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(CustomBackGround)
        ){
            WeatherCard(state = state)
            Spacer(modifier = Modifier.height(10.dp))
            WeatherForecast(state = state)
        }
        if (state.isLoading){
            LoadingIndicator()
        }
    }
    state.error?.let {error ->
        ErrorContent(errorMessage = error) {
            viewModel.clearError()
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            )
        }
    }
}