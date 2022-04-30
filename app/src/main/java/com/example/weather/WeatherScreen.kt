package com.example.weather

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

enum class WeatherScreen (val iconId: Int){
    Overview(
        iconId = R.drawable.ic_baseline_cloud_24
    ),
    Locations(
        iconId = R.drawable.ic_baseline_list_24
    ),
    Map(
        iconId = R.drawable.ic_baseline_location_on_24
    );

    companion object {
        fun fromRoute(route: String?): WeatherScreen {
            return when (route?.substringBefore("/")) {
                Overview.name -> Overview
                Locations.name -> Locations
                Map.name -> Map
                null -> Overview
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
        }
    }
}
