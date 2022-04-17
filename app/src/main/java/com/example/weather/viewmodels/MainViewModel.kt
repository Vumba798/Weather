package com.example.weather.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.model.remote.apiresponse.OneCallResponse
import com.example.weather.model.remote.WeatherClient
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val myResponse = MutableLiveData<OneCallResponse>()

    fun getCurrentWeather() {
        viewModelScope.launch {
            myResponse.value = WeatherClient.retrofit.getCurrentWeather(1.5434F, 2.4123F)
        }
    }
}