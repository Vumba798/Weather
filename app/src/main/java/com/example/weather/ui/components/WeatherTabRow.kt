package com.example.weather.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.example.weather.WeatherScreen
import java.util.*

val TabHeight = 56.dp
val InnactiveTabOpacity = 0.6f

@Composable
fun WeatherTabRow(
    allScreens: List<WeatherScreen>,
    onTabSelected: (WeatherScreen) -> Unit,
    currentScreen: WeatherScreen
) {
    Surface (
        Modifier
            .height(TabHeight)
            .fillMaxWidth()
    ) {
        allScreens.forEach { screen ->
            WeatherTab(
                text = screen.name,
                iconId = screen.iconId,
                onSelected = { onTabSelected(screen) },
                selected = currentScreen == screen
            )
        }
    }
}

@Composable
fun WeatherTab(
    text: String,
    iconId: Int,
    onSelected: () -> Unit,
    selected: Boolean
) {
    val color = MaterialTheme.colors.onSurface
    val tabTintColor by animateColorAsState(
        targetValue = if (selected) color else color.copy(alpha = InnactiveTabOpacity)
    )

    Row(
        modifier = Modifier
            .padding(16.dp)
            .animateContentSize()
            .height(TabHeight)
            .selectable(
                selected = selected,
                onClick = onSelected,
                role = Role.Tab
            )
    ) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = null
        )
        if (selected) {
            Spacer(Modifier.width(12.dp))
            Text(text.uppercase(Locale.getDefault()), color = tabTintColor)
        }
    }
}