package com.example.weather.ui.shared

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RowOfData(modifier: Modifier = Modifier, left: String, right: String? = null) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            text = left,
            modifier = Modifier
                .weight(1f)
        )
        right?.let {
            Text(
                text = it,
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}
