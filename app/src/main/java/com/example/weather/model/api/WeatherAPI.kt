package com.example.weather.model.api

import com.example.weather.model.api.response.OneCallResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("data/2.5/onecall?units=metric&appid=baf72db3654954826b60cb091c854cf6")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float): OneCallResponse
}