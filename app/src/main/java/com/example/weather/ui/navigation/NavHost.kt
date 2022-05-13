package com.example.weather.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weather.ui.screens.LocationsScreen
import com.example.weather.ui.screens.SettingsScreen
import com.example.weather.ui.screens.daily.DailyScreen
import com.example.weather.ui.screens.details.DetailsScreen
import com.example.weather.ui.screens.hourly.HourlyScreen
import com.example.weather.ui.screens.minutely.MinutelyScreen
import com.example.weather.ui.screens.overview.OverviewScreen


@Composable
fun NavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavDrawerItem.Overview.route,
    ) {
        composable(
            route = OverviewItem.Details.route
        ) {
            DetailsScreen()
        }
        composable(
            route = OverviewItem.Minutely.route,
        ) {
            MinutelyScreen()
        }
        composable(
            route = OverviewItem.Hourly.route
        ) {
            HourlyScreen()
        }
        composable(
            route = OverviewItem.Daily.route
        ) {
            DailyScreen()
        }
        composable(
            route = NavDrawerItem.Overview.route
        ) {
            OverviewScreen(navController)
        }
        composable(
            route = NavDrawerItem.ChangeLocation.route
        ) {
            LocationsScreen()
        }
        composable(
            route = NavDrawerItem.Settings.route
        ) {
            SettingsScreen()
        }
    }
}
