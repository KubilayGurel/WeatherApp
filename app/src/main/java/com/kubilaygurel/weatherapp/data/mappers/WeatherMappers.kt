package com.kubilaygurel.weatherapp.data.mappers

import com.kubilaygurel.weatherapp.data.remote.WeatherDTO
import com.kubilaygurel.weatherapp.data.remote.WeatherDataDTO
import com.kubilaygurel.weatherapp.domain.weather.WeatherData
import com.kubilaygurel.weatherapp.domain.weather.WeatherInfo
import com.kubilaygurel.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private data class IndexedWeatherData(
    val index: Int,
    val data : WeatherData
)

fun WeatherDataDTO.toWeatherDataMap(): Map<Int, List<WeatherData>>{
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map {it.data}
    }
}

fun WeatherDTO.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
    it.time.hour == hour

    }
    return WeatherInfo(
        weatherDataPerday = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}