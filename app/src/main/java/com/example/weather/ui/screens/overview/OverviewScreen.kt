package com.example.weather.ui.screens.overview

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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

