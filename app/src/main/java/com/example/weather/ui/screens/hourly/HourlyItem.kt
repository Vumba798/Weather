package com.example.weather.ui.screens.hourly

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.model.local.entities.Hour
import com.example.weather.ui.shared.ItemBasicInfo
import com.example.weather.ui.shared.RowOfData
import com.example.weather.ui.theme.Blue
import com.example.weather.ui.theme.Orange
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HourlyItem(hour: Hour) {
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
           temperature = hour.temp,
           expanded = expanded,
           onExpandedChange = { expanded = !expanded },
           sdfPattern = " dd/MM HH:mm",
           timeZone = "Europe/Moscow",
       )
        if (expanded) {
            HourlyItemDetails(hour = hour)
        }
    }
}

@Composable
fun HourlyItemDetails(hour: Hour) {
    with(hour) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            RowOfData(left = "feels like: $feels_like℃", right =  "pressure: $pressure hPa")
            RowOfData(left = "humidity: $humidity%", right =  "dew point: $dew_point℃")
            RowOfData(left = "uvi: $uvi", right =  "clouds: $clouds%")
            RowOfData(left = "visibility: $visibility m", right = "wind speed: $wind_speed km/h")
            RowOfData(left = "wind deg: $wind_deg°", right = "wind gust: $wind_gust km/h")
            RowOfData(left = "weather main: $weather_main", modifier = Modifier.padding(top = 5.dp))
            RowOfData(left = "weather description: $weather_description")
            RowOfData(left = "probability of precipitation: $pop%")
        }
    }
}
