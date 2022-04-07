package com.example.weather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.weather.Address
import com.example.weather.AppDataBase
import com.example.weather.R
import com.example.weather.User
import com.example.weather.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
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

        val userDao = db.userDao()
        val user = User(1, 1, "Alex", "Smith",
            Address("Moscow", "Pushkina", arrayOf(1, 2)))
        userDao.delete(user)

        val allUsers = userDao.getAll()
        for (elem in allUsers) {
            Log.d("Dao", elem.toString())
        }
    }
}
