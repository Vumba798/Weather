package com.example.weather.model

import com.example.weather.model.local.*
import com.example.weather.model.remote.WeatherApi

class WeatherRepository(
    private val weatherApi: WeatherApi,
    private val locationDao: LocationDao,
    private val minuteDao: MinuteDao,
    private val hourDao: HourDao,
    private val dayDao: DayDao
    ) {
    suspend fun refresh(lat: Double, lon: Double) {
    }

    private fun isInternetAvailable(): Boolean {
    }
}