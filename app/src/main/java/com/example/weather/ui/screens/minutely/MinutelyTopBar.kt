package com.example.weather.ui.screens.minutely

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.DarkBlue

@Composable
fun MinutelyTopBar() {
    // TODO Remove it???
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = DarkBlue)
                .padding(10.dp)
        ) {
            Text(
                text = "Time",
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )
            Text(
                text = "Precipitation",
                textAlign = TextAlign.End,
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }
}