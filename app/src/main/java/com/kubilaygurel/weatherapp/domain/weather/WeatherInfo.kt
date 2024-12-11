package com.kubilaygurel.weatherapp.domain.weather

data class WeatherInfo (
    val weatherDataPerday: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)