package com.example.weather.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.weather.R
import com.example.weather.model.local.AppDataBase
import com.example.weather.model.local.entities.Hour
import com.example.weather.model.local.entities.Location
import com.example.weather.model.local.entities.Minute
import com.example.weather.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // viewModel.getCurrentWeather()
        /*
        viewModel.myResponse.observe(this, Observer {
            Log.d("GET REQUEST", it.current.toString())
        })
         */
        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "database for study")
            .allowMainThreadQueries()
            .build()

        db.clearAllTables()
        /*
        val weatherDao = db.weatherDao()

        val a1 = Location(0.0f, 0.0f)
        val a2 = Location(1.0f, 1.0f)
        val m1 = Minute(a1.lat, a1.lon, 0, 20)
        val m2 = Minute(a1.lat, a1.lon, 1, 30)
        val h1 = Hour(a2.lat, a2.lon, 0, 4)
        val h2 = Hour(a2.lat, a2.lon, 1, 4)

        weatherDao.insertLocations(a1, a2)
        weatherDao.insertMinutes(m1, m2)

        val new1 = weatherDao.getAll()
        Log.d("DATABASE", new1.toString())
         */

    }
}
