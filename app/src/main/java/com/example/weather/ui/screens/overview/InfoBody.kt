package com.example.weather.ui.screens.overview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weather.ui.navigation.OverviewItem
import com.example.weather.ui.theme.Blue

@Composable
fun InfoBody(
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10))
            .background(Blue)
    ) {
        BasicInfo(navController)
    }
}

@Composable
fun BasicInfo(
    navController: NavHostController
) {
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
        OutlinedButton(
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
            border = BorderStroke(width = 1.dp, color = DarkGray),
            onClick = { navController.navigate(OverviewItem.Details.route) },
            modifier = Modifier
                .clip(RoundedCornerShape(10)),
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
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f),
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = nameLeft,
                modifier = Modifier
                    .alpha(alpha),
            )
            Text(valueLeft)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f),
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = nameRight,
                modifier = Modifier
                    .alpha(alpha)
            )
            Text(valueRight)
        }
    }
}
