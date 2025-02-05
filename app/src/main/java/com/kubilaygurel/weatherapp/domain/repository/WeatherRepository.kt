package com.kubilaygurel.weatherapp.domain.repository

import com.kubilaygurel.weatherapp.domain.util.Resource
import com.kubilaygurel.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>

}