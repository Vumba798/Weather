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
            lat = lat,
            lon = lon,
            offset = index,
            dt = day.dt,
            sunrise = day.sunrise,
            sunset = day.sunset,
            moonrise = day.moonrise,
            moonset = day.moonset,
            moon_phase = day.moonPhase,
            temp_min = day.temp.min,
            temp_max = day.temp.max,
            temp_morn = day.temp.morn,
            temp_day = day.temp.day,
            temp_eve = day.temp.eve,
            temp_night = day.temp.night,
            feels_like_morn = day.feelsLike.morn,
            feels_like_day = day.feelsLike.day,
            feels_like_eve = day.feelsLike.eve,
            feels_like_night = day.feelsLike.night,
            pressure = day.pressure,
            humidity = day.humidity,
            dew_point = day.dewPoint,
            wind_speed = day.windSpeed,
            wind_deg = day.windDeg,
            wind_gust = day.windGust,
            weather_id = day.weather[0].id,
            weather_main = day.weather[0].main,
            weather_description = day.weather[0].description,
            weather_icon = day.weather[0].icon,
            clouds = day.clouds,
            pop = day.pop,
            uvi = day.uvi
        ))
    }
    return days
}
