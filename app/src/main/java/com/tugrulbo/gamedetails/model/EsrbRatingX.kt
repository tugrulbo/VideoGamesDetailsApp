package com.tugrulbo.gamedetails.model


import com.google.gson.annotations.SerializedName

data class EsrbRatingX(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("slug")
    var slug: String
)