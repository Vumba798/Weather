package com.example.weather.model.local.entities

import androidx.room.*
import com.example.weather.model.remote.apiresponse.OneCallResponse

@Entity(primaryKeys = ["lat", "lon"])
data class Location (
    var lat: Float,
    var lon: Float,
    var timezone: String,
    var timezoneOffset: Int
)

fun OneCallResponse.toLocation(): Location {
    return Location(lat, lon, timezone, timezoneOffset)
}