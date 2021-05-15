package com.tugrulbo.gamedetails.model


import com.google.gson.annotations.SerializedName

data class PlatformXXXX(
    @SerializedName("platform")
    var platform: PlatformXXXXX,
    @SerializedName("released_at")
    var releasedAt: String,
    @SerializedName("requirements")
    var requirements: RequirementsX
)