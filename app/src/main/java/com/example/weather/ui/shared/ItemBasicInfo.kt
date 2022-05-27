package com.example.weather.ui.shared

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.ui.theme.Orange
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ItemBasicInfo(
    temperature: Float,
    expanded: Boolean,
    onExpandedChange: () -> Unit,
    sdfPattern: String,
    timeZone: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Column() {
            val sdf = SimpleDateFormat(sdfPattern)
            //TODO get timezone from a device
            sdf.timeZone = TimeZone.getTimeZone(timeZone)
            val time = Date(1653662589L * 1000)
            Text(
                text = sdf.format(time),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 10.dp)
            ) {
                Icon(
                    // TODO extract id
                    modifier = Modifier
                        .size(40.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                    contentDescription = null,
                    tint = Orange
                )
                Text(
                    text = "$temperature℃",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = onExpandedChange
        ) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = null
            )
        }

    }
}
