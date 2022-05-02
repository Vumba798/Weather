package com.example.weather.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.Blue
import com.example.weather.ui.theme.DarkBlue
import com.example.weather.ui.theme.LightBlue
import com.example.weather.ui.theme.Orange

@Composable
fun OverviewBody() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
    ) {
        TemperatureRow()
        InfoBody()
    }
}

@Composable
fun TemperatureRow() {
    Box(Modifier
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
                painter = painterResource(id = com.example.weather.R.drawable.ic_baseline_wb_sunny_24),
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
    Box(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()
        .clip(RoundedCornerShape(5))
        .background(Blue)
    ) {
        Column() {
        }
    }
}

@Composable
fun BasicInfo() {
}

@Composable
fun NearestForecastRow() {
    Row(modifier = Modifier
        .padding(5.dp)
    ) {

    }
}

@Composable
fun NearestForecastRowCell() {
    Column(
    ) {
        //TODO get from database
        val precipitation = 10
        val temperature = 20
        val feelsLike = 16


    }
}