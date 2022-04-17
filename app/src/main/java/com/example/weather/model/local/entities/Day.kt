package com.example.weather.model.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.weather.model.remote.apiresponse.OneCallResponse

@Entity(foreignKeys = [
    ForeignKey(entity = Location::class,
        parentColumns = ["lat", "lon"],
        childColumns = ["lat", "lon"])],
    primaryKeys = ["lat", "lon", "offset"]
)
data class Day (
    var lat: Float,
    var lon: Float,
    var offset: Int,
    var dt: Int,
    var sunrise: Int,
    var sunset: Int,
    var moonrise: Int,
    var moonset: Int,
    var moon_phase: Float,
    var temp_min: Float,
    var temp_max: Float,
    var temp_morn: Float,
    var temp_day: Float,
    var temp_eve: Float,
    var temp_night: Float,
    var feels_like_morn: Float,
    var feels_like_day: Float,
    var feels_like_eve: Float,
    var feels_like_night: Float,
    var pressure: Int,
    var humidity: Int,
    var dew_point: Float,
    var wind_speed: Float,
    var wind_deg: Int,
    var wind_gust: Float,
    var weather_id: Int,
    var weather_main: String,
    var weather_description: String,
    var weather_icon: String,
    var clouds: Int,
    var pop: Float,
    var uvi: Float
)

fun OneCallResponse.toDays(): List<Day> {
    val days = mutableListOf<Day>()
    for ((index, day) in daily.withIndex()) {
        days.add(Day(
            lat, lon, index,
            day.dt,
            day.sunrise,
            day.sunset,
            day.moonrise,
            day.moonset,
            day.moonPhase,
            day.temp.min,
            day.temp.max,
            day.temp.morn,
            day.temp.day,
            day.temp.eve,
            day.temp.night,
            day.feelsLike.morn,
            day.feelsLike.day,
            day.feelsLike.eve,
            day.feelsLike.night,
            day.pressure,
            day.humidity,
            day.dewPoint,
            day.windSpeed,
            day.windDeg,
            day.windGust,
            day.weather[0].id,
            day.weather[0].main,
            day.weather[0].description,
            day.weather[0].icon,
            day.clouds,
            day.pop,
            day.uvi
        ))
    }
    return days
}
