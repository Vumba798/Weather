package com.example.weather.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weather.model.local.entities.Day
import com.example.weather.model.local.entities.Hour
import com.example.weather.model.local.entities.Location
import com.example.weather.model.local.entities.Minute

@Database(entities = [
    Location::class,
    Minute::class,
    Hour::class,
    Day::class],

    version = 1
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
    abstract fun minuteDao(): MinuteDao
    abstract fun hourDao(): HourDao
    abstract fun dayDao(): DayDao
}