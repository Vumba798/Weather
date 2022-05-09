package com.example.weather.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weather.ui.screens.LocationsBody
import com.example.weather.ui.screens.SettingsBody
import com.example.weather.ui.screens.overview.OverviewBody

@Composable
fun NavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavDrawerItem.Overview.route
    ) {
        composable(NavDrawerItem.Overview.route) {
            OverviewBody()
        }
        composable(NavDrawerItem.ChangeLocation.route) {
            LocationsBody()
        }
        composable(NavDrawerItem.Settings.route) {
            SettingsBody()
        }
    }
}
