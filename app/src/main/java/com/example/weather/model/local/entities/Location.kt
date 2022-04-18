package com.example.weather.model.local.entities

import androidx.room.*
import com.example.weather.model.remote.apiresponse.OneCallResponse

@Entity(primaryKeys = ["lat", "lon"])
data class Location (
    var lat: Float,
    var lon: Float,
    var timezone: String,
    var timezone_offset: Int
)

fun OneCallResponse.toLocation(): Location {
    return Location(
        lat = lat,
        lon = lon,
        timezone = timezone,
        timezone_offset = timezoneOffset)
}