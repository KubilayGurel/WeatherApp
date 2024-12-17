package com.kubilaygurel.weatherapp.data.remote

import com.google.gson.annotations.SerializedName


data class WeatherDTO (
    @SerializedName("hourly")
    val weatherData: WeatherDataDTO
)