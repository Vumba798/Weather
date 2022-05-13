package com.example.weather.ui.screens.overview

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weather.ui.navigation.OverviewItem
import com.example.weather.ui.theme.Blue

@Composable
fun ButtonsRow(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Row(modifier = modifier
        .fillMaxWidth()
    ) {
        Button(modifier = Modifier
            .padding(horizontal = 5.dp)
            .weight(1f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
            // TODO
            onClick = { navController.navigate(OverviewItem.Minutely.route) }
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
            onClick = { navController.navigate(OverviewItem.Hourly.route) }
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
            onClick = { navController.navigate(OverviewItem.Daily.route) }
        ) {
            Text(
                text =  "Daily",
                color = Color.Black
            )
        }
    }
}
