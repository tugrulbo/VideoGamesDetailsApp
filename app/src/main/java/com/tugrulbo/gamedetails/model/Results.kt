package com.tugrulbo.videogamesdatabase.model


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("added")
    var added: Int,
    @SerializedName("background_image")
    var backgroundİmage: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("metacritic")
    var metacritic: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("playtime")
    var playtime: Int,
    @SerializedName("rating")
    var rating: Double,
    @SerializedName("rating_top")
    var ratingTop: Double,
    @SerializedName("ratings_count")
    var ratingsCount: Int,
    @SerializedName("released")
    var released: String,
    @SerializedName("reviews_text_count")
    var reviewsTextCount: String,
    @SerializedName("slug")
    var slug: String,
    @SerializedName("suggestions_count")
    var suggestionsCount: Int,
    @SerializedName("tba")
    var tba: Boolean,
    @SerializedName("updated")
    var updated: String
)