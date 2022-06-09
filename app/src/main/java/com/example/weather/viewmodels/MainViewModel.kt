package com.example.weather.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.model.WeatherRepository
import com.example.weather.model.local.entities.Day
import com.example.weather.model.local.entities.Hour
import com.example.weather.model.local.entities.Location
import com.example.weather.model.local.entities.Minute
import com.example.weather.model.remote.apiResponse.OneCallResponse
import com.example.weather.model.remote.WeatherClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: WeatherRepository): ViewModel() {
    var days = MutableLiveData<List<Day>>()
        private set

    var minutes = MutableLiveData<List<Minute>>()
        private set

    var hours = MutableLiveData<List<Hour>>()
        private set

    var locations = MutableLiveData<List<Location>>()
        private set

    fun updateData(lat: Double, lon: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.refresh(lat, lon)
        }
    }
}