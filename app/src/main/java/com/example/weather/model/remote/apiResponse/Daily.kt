package com.example.example

import com.google.gson.annotations.SerializedName


data class Daily (

  @SerializedName("dt"         ) var dt        : Int               ,
  @SerializedName("sunrise"    ) var sunrise   : Int               ,
  @SerializedName("sunset"     ) var sunset    : Int               ,
  @SerializedName("moonrise"   ) var moonrise  : Int               ,
  @SerializedName("moonset"    ) var moonset   : Int               ,
  @SerializedName("moon_phase" ) var moonPhase : Float            ,
  @SerializedName("temp"       ) var temp      : Temp              ,
  @SerializedName("feels_like" ) var feelsLike : FeelsLike         ,
  @SerializedName("pressure"   ) var pressure  : Int               ,
  @SerializedName("humidity"   ) var humidity  : Int               ,
  @SerializedName("dew_point"  ) var dewPoint  : Float            ,
  @SerializedName("wind_speed" ) var windSpeed : Float            ,
  @SerializedName("wind_deg"   ) var windDeg   : Int               ,
  @SerializedName("wind_gust"  ) var windGust  : Float            ,
  @SerializedName("weather"    ) var weather   : ArrayList<Weather> = arrayListOf(),
  @SerializedName("clouds"     ) var clouds    : Int               ,
  @SerializedName("pop"        ) var pop       : Float            ,
  @SerializedName("uvi"        ) var uvi       : Float

)