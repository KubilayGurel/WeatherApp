package com.kubilaygurel.weatherapp.di

import com.kubilaygurel.weatherapp.data.location.DefaultLocationTracker
import com.kubilaygurel.weatherapp.data.repository.WeatherRepositoryImpl
import com.kubilaygurel.weatherapp.domain.location.LocationTracker
import com.kubilaygurel.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
       weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}