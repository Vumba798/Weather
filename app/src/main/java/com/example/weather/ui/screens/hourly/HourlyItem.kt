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
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.model.local.entities.Hour
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
        HourlyItemTop(hour.temp, expanded) {
            expanded = !expanded
        }
        
        if (expanded) {
            HourlyItemDetails(hour = hour)
        }
    }
}

@Composable
fun HourlyItemTop(
    temperature: Float,
    expanded: Boolean,
    onExpandedChange: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Column() {
            val sdf = SimpleDateFormat(" dd/MM HH:mm")
            //TODO get timezone from a device
            sdf.timeZone = TimeZone.getTimeZone("Europe/Moscow")
            val time = Date(1653662589L * 1000)
            Text(
                text = sdf.format(time),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 10.dp)
            ) {
                Icon(
                    // TODO extract id
                    modifier = Modifier
                        .size(40.dp),
                    painter = painterResource(id = com.example.weather.R.drawable.ic_baseline_wb_sunny_24),
                    contentDescription = null,
                    tint = Orange
                )
                Text(
                    text = "$temperature℃",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = onExpandedChange
        ) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = null
            )
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

@Composable
fun RowOfData(modifier: Modifier = Modifier, left: String, right: String? = null) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            text = left,
            modifier = Modifier
                .weight(1f)
        )
        right?.let {
            Text(
                text = it,
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}