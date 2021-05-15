package com.tugrulbo.gamedetails.model


import com.google.gson.annotations.SerializedName

data class RequirementsX(
    @SerializedName("minimum")
    var minimum: String,
    @SerializedName("recommended")
    var recommended: String
)