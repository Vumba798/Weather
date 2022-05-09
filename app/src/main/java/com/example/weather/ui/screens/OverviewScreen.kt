package com.example.weather.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.*
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.ui.theme.Blue
import com.example.weather.ui.theme.DarkBlue
import com.example.weather.ui.theme.LightBlue
import com.example.weather.ui.theme.Orange

@Composable
fun OverviewBody() {
    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            TemperatureRow()
            NearestForecastRow()
            InfoBody()
        }
        ButtonsRow(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun TemperatureRow() {
    Box(
        Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(20))
            .background(Blue)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .background(Blue)
        ) {
            Icon(
                // TODO extract id
                modifier = Modifier
                    .size(50.dp)
                    .weight(1f),
                painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                contentDescription = null,
                tint = Orange
            )
            // TODO temp
            val temp = "24"
            Text(
                modifier = Modifier.weight(2f),
                text = "$temp ℃",
                fontSize = 50.sp
            )
        }
    }
}

@Composable
fun InfoBody() {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10))
            .background(Blue)
    ) {
        BasicInfo()
    }
}



@Composable
fun BasicInfo() {
    //TODO get values
    val feelsLike = 16
    val humidity = 40
    val windSpeed = 8.8f
    val precipitation = 0.4f
    val sunRise = "4:40"
    val sunSet = "21:45"

    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column() {
            BasicInfoRow(
                nameLeft = "Feels Like", valueLeft = "$feelsLike ℃",
                nameRight = "Humidity", valueRight = "$humidity %"
            )
            BasicInfoRow(
                nameLeft = "Wind speed", valueLeft = "$windSpeed km/h",
                nameRight = "Precipitation", valueRight = "${precipitation * 100} %"
            )
            BasicInfoRow(
                nameLeft = "Sun rise", valueLeft = sunRise,
                nameRight = "Sun set", valueRight = sunSet
            )
        }
        Button(modifier = Modifier
            .clip(RoundedCornerShape(10)),
            colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue),
            // TODO
            onClick = { }
        ) {
            Text(
                text = "Details",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun BasicInfoRow(
    nameLeft: String, valueLeft: String,
    nameRight: String, valueRight: String,
    alpha: Float = 0.6f
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .alpha(alpha),
                textAlign = TextAlign.Center,
                text = nameLeft,
            )
            Text(valueLeft)
        }
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .alpha(alpha),
                textAlign = TextAlign.Center,
                text = nameRight
            )
            Text(valueRight)
        }
    }
}

data class NearestForecastElement(
    val time: String,
    val iconId: Int,
    val temp: Int
)

@Composable
fun NearestForecastRow() {
    val nearestForecast = listOf(
        NearestForecastElement("4:00", R.drawable.ic_baseline_cloud_24, 20),
        NearestForecastElement("5:00", R.drawable.ic_baseline_cloud_24, 21),
        NearestForecastElement("6:00", R.drawable.ic_baseline_cloud_24, 22),
        NearestForecastElement("7:00", R.drawable.ic_baseline_cloud_24, 22),
        NearestForecastElement("8:00", R.drawable.ic_baseline_cloud_24, 23),
        NearestForecastElement("9:00", R.drawable.ic_baseline_cloud_24, 23),
        NearestForecastElement("10:00", R.drawable.ic_baseline_cloud_24, 23),
        NearestForecastElement("11:00", R.drawable.ic_baseline_wb_sunny_24,25),
        NearestForecastElement("12:00", R.drawable.ic_baseline_wb_sunny_24, 30),
        NearestForecastElement("13:00", R.drawable.ic_baseline_wb_sunny_24, 32),
    )
    LazyRow(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .graphicsLayer { alpha = 0.99f }
        .drawWithContent {
            val colors = listOf(Color.Transparent, Color.Black)
            drawContent()
            drawRect(
                brush = Brush.horizontalGradient(colors),
                blendMode = BlendMode.Dst
            )
        },
    ) {
        items(items = nearestForecast, itemContent = { item ->
            NearestForecastRowCell(data = item)
        })
    }
    /*
    Row(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
    ) {
        NearestForecastRowCell(modifier = Modifier.weight(1f))
        NearestForecastRowCell(modifier = Modifier.weight(1f))
        NearestForecastRowCell(modifier = Modifier.weight(1f))
    }
     */
}

@Composable
fun NearestForecastRowCell(modifier: Modifier = Modifier, data: NearestForecastElement) {
    Column(modifier = modifier
        .padding(5.dp)
        .clip(RoundedCornerShape(15.dp))
        .background(Blue)
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //TODO get from database
        val iconId = data.iconId
        val time = data.time
        val temperature = data.temp

        Text(time)
        Icon(
            painter = painterResource(iconId),
            contentDescription = null
        )
        Text("$temperature ℃")
    }
}

@Composable
fun ButtonsRow(modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
    ) {
        Button(modifier = Modifier
            .padding(horizontal = 5.dp)
            .weight(1f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
            // TODO
            onClick = {  }
        ) {
            Text(
                text =  "Minutely",
                color = Color.Black
            )
        }
        Button(modifier = Modifier
            .padding(horizontal = 5.dp)
            .weight(1f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
            // TODO
            onClick = {  }
        ) {
            Text(
                text =  "Hourly",
                color = Color.Black
            )
        }
        Button(modifier = Modifier
            .padding(horizontal = 5.dp)
            .weight(1f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
            // TODO
            onClick = {  }
        ) {
            Text(
                text =  "Daily",
                color = Color.Black
            )
        }
    }
}