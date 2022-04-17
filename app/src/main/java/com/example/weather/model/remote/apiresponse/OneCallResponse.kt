package com.example.weather.model.remote.apiresponse

import com.example.example.Current
import com.example.example.Daily
import com.example.example.Hourly
import com.example.example.Minutely
import com.google.gson.annotations.SerializedName


data class OneCallResponse (

  @SerializedName("lat"             ) var lat            : Float             ,
  @SerializedName("lon"             ) var lon            : Float             ,
  @SerializedName("timezone"        ) var timezone       : String             ,
  @SerializedName("timezone_offset" ) var timezoneOffset : Int                ,
  @SerializedName("current"         ) var current        : Current            ,
  @SerializedName("minutely"        ) var minutely       : ArrayList<Minutely> = arrayListOf(),
  @SerializedName("hourly"          ) var hourly         : ArrayList<Hourly>   = arrayListOf(),
  @SerializedName("daily"           ) var daily          : ArrayList<Daily>    = arrayListOf()

)