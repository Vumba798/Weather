package com.example.weather.ui.screens.daily

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.weather.model.local.entities.Day
import com.example.weather.ui.shared.ItemBasicInfo
import com.example.weather.ui.shared.RowOfData
import com.example.weather.ui.theme.Blue
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DailyItem(day: Day) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(if (expanded) 5 else 20))
            .background(Blue)
            .padding(5.dp)
    ) {
        ItemBasicInfo(
            temperature = day.temp_day,
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            sdfPattern = " dd/MM",
            timeZone = "Europe/Moscow"
        )

        if (expanded) {
            DailyItemDetails(day = day)
        }
    }
}

@Composable
fun DailyItemDetails(
    day: Day
) {
    val timeZoneId = "Europe/Moscow"
    with(day) {
        val sunriseFormatted = SimpleDateFormat("HH:mm").run {
            timeZone = TimeZone.getTimeZone(timeZoneId)
            format(sunrise.toLong() * 1000)
        }
        val sunsetFormatted = SimpleDateFormat("HH:mm").run {
            timeZone = TimeZone.getTimeZone(timeZoneId)
            format(sunset.toLong() * 1000)
        }
        val moonRiseFormatted = SimpleDateFormat("HH:mm").run {
            timeZone = TimeZone.getTimeZone(timeZoneId)
            format(moonrise.toLong() * 1000)
        }
        val moonsetFormatted = SimpleDateFormat("HH:mm").run {
            timeZone = TimeZone.getTimeZone(timeZoneId)
            format(moonset.toLong() * 1000)
        }

        RowOfData(left = "weather main: $weather_main", modifier = Modifier.padding(top = 5.dp))
        RowOfData(left = "weather description: $weather_description")
        RowOfData(left = "probability of precipitation: $pop%")
        RowOfData(left = "temp min: $temp_min", right = "temp max: $temp_max")
        RowOfData(left = "temp morn: $temp_morn", right = "temp day: $temp_day")
        RowOfData(left = "temp eve: $temp_eve", right = "temp night: $temp_night")
        RowOfData(left = "feels like morn: $feels_like_morn", right = "feels like day: $feels_like_day")
        RowOfData(left = "feels like eve: $feels_like_day", right = "feels like night: $feels_like_night")
        RowOfData(left = "sunrise: $sunriseFormatted", right = "sunset: $sunsetFormatted")
        RowOfData(left = "moonrise: $moonRiseFormatted", right = "moonset: $moonsetFormatted")
        // TODO split float moon_phase into names like "full moon"
        RowOfData(left = "moonphase = $moon_phase")
        RowOfData(left = "humidity: $humidity%", right =  "dew point: $dew_point℃")
        RowOfData(left = "uvi: $uvi", right =  "clouds: $clouds%")
        RowOfData(left = "pressure: $pressure hPa", right = "wind speed: $wind_speed km/h")
        RowOfData(left = "wind deg: $wind_deg°", right = "wind gust: $wind_gust km/h")
        // TODO add snow and rain volume
        // TODO add alerts
    }
}