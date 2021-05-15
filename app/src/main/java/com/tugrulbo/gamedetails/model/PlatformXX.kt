package com.tugrulbo.gamedetails.model


import com.google.gson.annotations.SerializedName

data class PlatformXX(
    @SerializedName("name")
    var name: String,
    @SerializedName("platform")
    var platform: Int,
    @SerializedName("slug")
    var slug: String
)