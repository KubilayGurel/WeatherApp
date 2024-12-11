package com.kubilaygurel.weatherapp.presentaion

import com.kubilaygurel.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
