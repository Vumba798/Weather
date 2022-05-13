package com.example.weather.ui.navigation

sealed class OverviewItem(
    val route: String
) {
    object Details: OverviewItem("Details")
    object Minutely: OverviewItem("Minutely")
    object Hourly: OverviewItem("Hourly")
    object Daily: OverviewItem("Daily")
}