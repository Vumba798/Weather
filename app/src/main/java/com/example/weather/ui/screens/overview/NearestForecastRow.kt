package com.example.weather.ui.screens.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.ui.theme.Blue


data class NearestForecastElement(
    val time: String,
    val iconId: Int,
    val temp: Int
)

@Composable
fun NearestForecastRow() {
    val nearestForecast = listOf(
        NearestForecastElement("4:00", R.drawable.ic_outline_wb_sunny_24, 20),
        NearestForecastElement("5:00", R.drawable.ic_outline_cloud_24, 21),
        NearestForecastElement("6:00", R.drawable.ic_outline_cloud_24, 22),
        NearestForecastElement("7:00", R.drawable.ic_outline_cloud_24, 22),
        NearestForecastElement("8:00", R.drawable.ic_outline_cloud_24, 23),
        NearestForecastElement("9:00", R.drawable.ic_outline_cloud_24, 23),
        NearestForecastElement("10:00", R.drawable.ic_outline_cloud_24, 23),
        NearestForecastElement("11:00", R.drawable.ic_outline_wb_sunny_24,25),
        NearestForecastElement("12:00", R.drawable.ic_outline_wb_sunny_24, 30),
        NearestForecastElement("13:00", R.drawable.ic_outline_wb_sunny_24, 32),
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
            tint = Color.DarkGray,

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
