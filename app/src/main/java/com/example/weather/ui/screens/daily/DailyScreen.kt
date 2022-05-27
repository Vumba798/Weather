package com.example.weather.ui.screens.daily

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.weather.model.local.entities.Day
import com.example.weather.ui.screens.hourly.HourlyItem

@Composable
fun DailyScreen() {
    val days: List<Day> = List(4) {
       Day(
            lat = 22.4f,
            lon = 23.5f,
            offset = 0,
            dt = 1652513673,
            sunrise = 1652000000,
            sunset = 1653000000,
            moonrise = 1652513000,
            moonset = 165252000,
            moon_phase = 0.7f,
            temp_min = 11.67f,
            temp_max = 20.88f,
            temp_morn = 11.80f,
            temp_day = 19.56f,
            temp_eve = 17.54f,
            temp_night = 15.43f,
            feels_like_morn = 8.12f,
            feels_like_day = 19.43f,
            feels_like_eve = 14.85f,
            feels_like_night = 13.40f,
            pressure = 1003,
            humidity = 52,
            dew_point = 2.94f,
            uvi = 0f,
            clouds = 31,
            wind_speed = 5.91f,
            wind_deg = 269,
            wind_gust = 12.66f,
            weather_id = 802,
            weather_main = "clouds",
            weather_description = "scattered clouds",
            weather_icon = "03d",
            pop = 0F,
        )
    }
    LazyColumn(

    ) {
        items(days) { day ->
            DailyItem(day)
        }
    }

}