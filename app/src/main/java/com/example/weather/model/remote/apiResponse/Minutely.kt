package com.example.example

import com.google.gson.annotations.SerializedName


data class Minutely (

  @SerializedName("dt"            ) var dt            : Int,
  @SerializedName("precipitation" ) var precipitation : Int

)