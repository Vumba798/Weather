package com.example.weather.ui.screens.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.ui.theme.Blue
import com.example.weather.ui.theme.Orange

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
