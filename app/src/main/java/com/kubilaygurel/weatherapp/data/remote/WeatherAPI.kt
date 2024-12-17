package com.kubilaygurel.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("v1/forecast")
    suspend fun getWeatherData (
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
        @Query("hourly") hourly: String = "temperature_2m,relativehumidity_2m,weathercode,pressure_msl,windspeed_10m"
    ):WeatherDTO
}
