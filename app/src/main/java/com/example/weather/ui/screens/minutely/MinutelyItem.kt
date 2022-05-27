package com.example.weather.ui.screens.minutely

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.Blue

@Composable
fun MinutelyItem(time: String, precipitation: Float) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(20))
            .background(color = Blue)
    ) {
        Row(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = time,
                    fontSize = 20.sp
                )
                Text(
                    text = "precipitation = ${(precipitation * 100).toInt()}%",
//                textAlign = TextAlign.End,
                    fontSize = 12.sp,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { expanded = !expanded },
                modifier = Modifier
                    .padding(top = 10.dp, end = 5.dp)
            ) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = null,
                )
            }
        }
    }
}


