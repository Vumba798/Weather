package com.example.weather.ui.screens.minutely

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.model.local.entities.Minute
import com.example.weather.ui.theme.Blue
import com.example.weather.ui.theme.DarkBlue

@Composable
fun MinutelyScreen() {
    // TODO load
    val data = listOf(
        Pair("13:40", 0.4f),
        Pair("13:41", 0.4f),
        Pair("13:42", 0.4f),
        Pair("13:43", 0.3f),
        Pair("13:44", 0.2f),
        Pair("13:45", 0.1f),
        Pair("13:46", 0.6f),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MinutelyTopBar()
        MinutelyItemList(data = data)
    }
}
