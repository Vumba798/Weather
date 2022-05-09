package com.example.weather.ui.navigation

import com.example.weather.R

sealed class NavDrawerItem(
    var route: String,
    var icon: Int,
    var title: String
) {
    object Overview: NavDrawerItem("Overview", R.drawable.ic_baseline_home_24, "Overview")
    object ChangeLocation: NavDrawerItem("changeLocation", R.drawable.ic_baseline_location_on_24, "Change location")
    object Settings: NavDrawerItem("settings", R.drawable.ic_baseline_settings_24, "Settings")
}