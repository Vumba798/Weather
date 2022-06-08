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
data class Minute (
    var lat: Float,
    var lon: Float,
    var offset: Int,
    var dt: Int,
    var precipitation: Int
)

fun OneCallResponse.toMinutes() : List<Minute> {
    val minutes = mutableListOf<Minute>()
    for ((index, minute) in minutely.withIndex()) {
        minutes.add(Minute(
            lat = lat,
            lon = lon,
            offset = index,
            dt = minute.dt,
            precipitation = minute.precipitation))
    }
    return minutes
}
