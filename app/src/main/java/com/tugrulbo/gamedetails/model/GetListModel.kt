package com.tugrulbo.videogamesdatabase.model


import com.google.gson.annotations.SerializedName

data class GetListModel(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: String,
    @SerializedName("results")
    var results: List<Results>
)