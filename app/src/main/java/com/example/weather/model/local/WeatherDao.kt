package com.example.weather.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.weather.model.local.entities.Day
import com.example.weather.model.local.entities.Hour
import com.example.weather.model.local.entities.Location
import com.example.weather.model.local.entities.Minute

data class Coordinates(
    val lat: Float,
    val lon: Float
)

@Dao
interface LocationDao {
    @Insert(onConflict = REPLACE)
    fun insertLocations(vararg location: Location)

    @Query("SELECT lat, lon FROM location")
    fun getCoordinates(): List<Coordinates>

    @Query("SELECT * FROM location")
    fun getAllLocations(): List<Location>
}
@Dao
interface MinuteDao {
    @Insert(onConflict = REPLACE)
    fun insert(vararg minute: Minute)

    @Query("SELECT * FROM minute WHERE lat LIKE :lat AND lon LIKE :lon")
    fun getMinutes(lat: Float, lon: Float): List<Minute>
}

@Dao
interface HourDao {
    @Insert(onConflict = REPLACE)
    fun insert(vararg hour: Hour)

    @Query("SELECT * FROM hour WHERE lat LIKE :lat AND lon LIKE :lon")
    fun getMinutes(lat: Float, lon: Float): List<Hour>
}

@Dao()
interface DayDao {
    @Insert(onConflict = REPLACE)
    fun insert(vararg day: Day)

    @Query("SELECT * FROM day WHERE lat LIKE :lat AND lon LIKE :lon")
    fun getMinutes(lat: Float, lon: Float): List<Day>
}