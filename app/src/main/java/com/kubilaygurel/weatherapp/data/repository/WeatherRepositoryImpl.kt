package com.kubilaygurel.weatherapp.data.repository

import com.kubilaygurel.weatherapp.data.mappers.toWeatherInfo
import com.kubilaygurel.weatherapp.data.remote.WeatherAPI
import com.kubilaygurel.weatherapp.domain.repository.WeatherRepository
import com.kubilaygurel.weatherapp.domain.util.Resource
import com.kubilaygurel.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherAPI
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
       return try {
           Resource.Success(
               data = api.getWeatherData(
                   lat = lat,
                   long = long
               ).toWeatherInfo()
           )

       } catch (e: Exception) {
           e.printStackTrace()
           Resource.Error(e.message ?: "An unknown error occurred.")
       }
    }
}