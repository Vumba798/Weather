package com.example.weather.ui.screens.minutely

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import java.lang.reflect.Modifier

@Composable
fun MinutelyItemList(
    data: List<Pair<String, Float>>
) {
    LazyColumn(
    ) {
        items(data) { (time, precipitation) ->
            MinutelyItem(time = time, precipitation = precipitation)
        }
    }
}
