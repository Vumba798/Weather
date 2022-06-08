package com.example.example

import com.google.gson.annotations.SerializedName


data class Current (

  @SerializedName("dt"         ) var dt         : Int               ,
  @SerializedName("sunrise"    ) var sunrise    : Int               ,
  @SerializedName("sunset"     ) var sunset     : Int               ,
  @SerializedName("temp"       ) var temp       : Float            ,
  @SerializedName("feels_like" ) var feelsLike  : Float            ,
  @SerializedName("pressure"   ) var pressure   : Int               ,
  @SerializedName("humidity"   ) var humidity   : Int               ,
  @SerializedName("dew_point"  ) var dewPoint   : Float            ,
  @SerializedName("uvi"        ) var uvi        : Float            ,
  @SerializedName("clouds"     ) var clouds     : Int               ,
  @SerializedName("visibility" ) var visibility : Int               ,
  @SerializedName("wind_speed" ) var windSpeed  : Float            ,
  @SerializedName("wind_deg"   ) var windDeg    : Int               ,
  @SerializedName("wind_gust"  ) var windGust   : Float            ,
  @SerializedName("weather"    ) var weather    : ArrayList<Weather> = arrayListOf()

)