package com.tugrulbo.videogamesdatabase.model


import com.google.gson.annotations.SerializedName

data class EsrbRating(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("slug")
    var slug: String
)