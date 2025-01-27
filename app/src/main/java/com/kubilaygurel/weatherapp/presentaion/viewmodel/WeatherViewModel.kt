package com.kubilaygurel.weatherapp.presentaion.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kubilaygurel.weatherapp.domain.location.LocationTracker
import com.kubilaygurel.weatherapp.domain.repository.WeatherRepository
import com.kubilaygurel.weatherapp.domain.util.Resource
import com.kubilaygurel.weatherapp.presentaion.state.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
): ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set


    fun updatePermissionDenied(isDenied: Boolean){
        state = state.copy(
            error = if (isDenied) "Location permissions are required to get weather data." else null,
        )
    }

    fun clearError(){
        state = state.copy(error = null)
    }

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when(val result = repository.getWeatherData(location.latitude,location.longitude)){
                    is Resource.Success -> {
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )

                    }
                    is Resource.Error -> {
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )

                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Unable to get location. Make sure location permissions are granted and GPS is turned on."
                )
            }
        }

    }

}