package com.example.weather.model.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.weather.model.remote.apiResponse.OneCallResponse

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
    var feels_like: Float,
    var pressure: Int,
    var humidity: Int,
    var dew_point: Float,
    var uvi: Float,
    var clouds: Int,
    var visibility: Int,
    var wind_speed: Float,
    var wind_deg: Int,
    var wind_gust: Float,
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
            lat = lat,
            lon = lon,
            offset = index,
            dt = hour.dt,
            temp = hour.temp,
            feels_like = hour.feelsLike,
            pressure = hour.pressure,
            humidity = hour.humidity,
            dew_point = hour.dewPoint,
            uvi = hour.uvi,
            clouds = hour.clouds,
            visibility = hour.visibility,
            wind_speed = hour.windSpeed,
            wind_deg = hour.windDeg,
            wind_gust = hour.windGust,
            weather_id = hour.weather[0].id,
            weather_main = hour.weather[0].main,
            weather_description = hour.weather[0].description,
            weather_icon = hour.weather[0].icon,
            pop = hour.pop
            ))
    }
    return hours
}