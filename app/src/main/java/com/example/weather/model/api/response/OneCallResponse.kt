package com.example.weather.model.api.response

import com.example.example.Current
import com.example.example.Daily
import com.example.example.Hourly
import com.example.example.Minutely
import com.google.gson.annotations.SerializedName


data class OneCallResponse (

  @SerializedName("lat"             ) var lat            : Double?             = null,
  @SerializedName("lon"             ) var lon            : Double?             = null,
  @SerializedName("timezone"        ) var timezone       : String?             = null,
  @SerializedName("timezone_offset" ) var timezoneOffset : Int?                = null,
  @SerializedName("current"         ) var current        : Current?            = Current(),
  @SerializedName("minutely"        ) var minutely       : ArrayList<Minutely> = arrayListOf(),
  @SerializedName("hourly"          ) var hourly         : ArrayList<Hourly>   = arrayListOf(),
  @SerializedName("daily"           ) var daily          : ArrayList<Daily>    = arrayListOf()

)