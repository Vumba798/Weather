package com.example.weather.ui.screens.hourly

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import com.example.weather.model.local.entities.Hour

@Composable
fun HourlyScreen() {
    // TODO get
    val hours = listOf(
        Hour(
            lat = 22.4f,
            lon = 23.5f,
            offset = 0,
            dt = 1652513673,
            temp = 11.67f,
            feels_like = 10.03f,
            pressure = 1003,
            humidity = 52,
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
            weather_icon = "03d",
            pop = 0
        ),
        Hour(
            lat = 22.4f,
            lon = 23.5f,
            offset = 0,
            dt = 1652513673,
            temp = 11.67f,
            feels_like = 10.03f,
            pressure = 1003,
            humidity = 52,
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
            weather_icon = "03d",
            pop = 0
        ),
        Hour(
            lat = 22.4f,
            lon = 23.5f,
            offset = 0,
            dt = 1652513673,
            temp = 11.67f,
            feels_like = 10.03f,
            pressure = 1003,
            humidity = 52,
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
            weather_icon = "03d",
            pop = 0
        ),
    )
    LazyColumn(

    ) {
        items(hours) { hour ->
            HourlyItem(hour)
        }
    }
}
