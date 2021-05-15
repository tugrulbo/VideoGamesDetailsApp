package com.tugrulbo.gamedetails.model


import com.google.gson.annotations.SerializedName

data class AddedByStatusX(
    @SerializedName("beaten")
    var beaten: Int,
    @SerializedName("dropped")
    var dropped: Int,
    @SerializedName("owned")
    var owned: Int,
    @SerializedName("playing")
    var playing: Int,
    @SerializedName("toplay")
    var toplay: Int,
    @SerializedName("yet")
    var yet: Int
)