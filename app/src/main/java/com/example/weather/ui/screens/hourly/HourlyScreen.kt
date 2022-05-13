package com.example.weather.ui.screens.hourly

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.weather.model.local.entities.Hour

@Composable
fun HourlyScreen() {
    val hour = Hour(
        lat = 22.4f,
        lon = 23.5f,
        offset = 0,
        temp = 11.67f,
        feels_like = 10.03f,
        dew_point = 2.94f,
        uvi = 0f,
        clouds = 31,
        visibility = 10000,
        wind_speed = 5.91f,
        wind_deg = 269,
        wind_gust = 12.66f,
        weather_id = 802,
        weather_main = "clouds",
        weather_description = "scattered clouds",
        weather_icon = "03d"
// TODO
    )
    Row()
}