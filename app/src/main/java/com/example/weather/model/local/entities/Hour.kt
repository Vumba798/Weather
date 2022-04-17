package com.example.weather.model.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.example.Hourly
import com.example.weather.model.remote.apiresponse.OneCallResponse

@Entity(foreignKeys = [
    ForeignKey(entity = Location::class,
        parentColumns = ["lat", "lon"],
        childColumns = ["lat", "lon"])],
    primaryKeys = ["lat", "lon", "offset"]
)
data class Hour (
    var lat: Float,
    var lon: Float,
    var offset: Int,
    var dt: Int,
    var temp: Float,
    var feelsLike: Float,
    var pressure: Int,
    var humidity: Int,
    var dewPoint: Float,
    var uvi: Float,
    var clouds: Int,
    var visibility: Int,
    var windSpeed: Float,
    var windDeg: Int,
    var windGust: Float,
    var weather_id: Int,
    var weather_main: String,
    var weather_description: String,
    var weather_icon: String,
    var pop: Int
)

fun OneCallResponse.toHours() : List<Hour> {
    val hours = mutableListOf<Hour>()
    for ((index, hour) in hourly.withIndex()) {
        hours.add(Hour(
            lat, lon, index,
            hour.dt,
            hour.temp,
            hour.feelsLike,
            hour.pressure,
            hour.humidity,
            hour.dewPoint,
            hour.uvi,
            hour.clouds,
            hour.visibility,
            hour.windSpeed,
            hour.windDeg,
            hour.windGust,
            hour.weather[0].id,
            hour.weather[0].main,
            hour.weather[0].description,
            hour.weather[0].icon,
            hour.pop
            ))
    }
    return hours
}