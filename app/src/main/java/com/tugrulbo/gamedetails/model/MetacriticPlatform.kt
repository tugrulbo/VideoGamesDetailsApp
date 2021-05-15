package com.tugrulbo.gamedetails.model


import com.google.gson.annotations.SerializedName

data class MetacriticPlatform(
    @SerializedName("metascore")
    var metascore: Int,
    @SerializedName("platform")
    var platform: PlatformXX,
    @SerializedName("url")
    var url: String
)