package com.tugrulbo.videogamesdatabase.model


import com.google.gson.annotations.SerializedName

data class Requirements(
    @SerializedName("minimum")
    var minimum: String,
    @SerializedName("recommended")
    var recommended: String
)