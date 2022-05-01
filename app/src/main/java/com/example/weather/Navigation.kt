package com.example.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weather.ui.screens.LocationsBody
import com.example.weather.ui.screens.MapBody
import com.example.weather.ui.screens.OverviewBody

@Composable
fun WeatherNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = WeatherScreen.Overview.name,
        modifier = modifier
    ) {
        composable(WeatherScreen.Overview.name) {
            OverviewBody()
        }
        composable(WeatherScreen.Locations.name) {
            LocationsBody()
        }
        composable(WeatherScreen.Map.name) {
            MapBody()
        }
    }
}