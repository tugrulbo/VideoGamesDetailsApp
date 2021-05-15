package com.tugrulbo.gamedetails.model


import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("id")
    var id: Int,
    @SerializedName("store")
    var store: StoreX,
    @SerializedName("url")
    var url: String
)