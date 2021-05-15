package com.tugrulbo.gamedetails.model


import com.google.gson.annotations.SerializedName

data class PlatformXXX(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("slug")
    var slug: String
)