package com.example.weather.ui.screens.overview

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

import com.example.weather.ui.screens.overview.*

@Composable
fun OverviewScreen(
    navController: NavHostController
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            TemperatureRow()
            NearestForecastRow()
            InfoBody(navController)
        }
        ButtonsRow(
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navController
        )
    }
}

