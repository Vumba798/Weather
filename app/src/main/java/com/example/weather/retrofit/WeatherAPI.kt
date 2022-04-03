package com.example.weather.retrofit

import com.example.weather.model.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("data/2.5/weather?units=metric&appid=baf72db3654954826b60cb091c854cf6")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float): WeatherModel
}