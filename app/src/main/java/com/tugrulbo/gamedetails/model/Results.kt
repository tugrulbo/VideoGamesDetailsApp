package com.tugrulbo.videogamesdatabase.model


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("added")
    var added: Int=0,
    @SerializedName("background_image")
    var backgroundImage: String="",
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("metacritic")
    var metacritic: Int=0,
    @SerializedName("name")
    var name: String="",
    @SerializedName("playtime")
    var playtime: Int=0,
    @SerializedName("rating")
    var rating: Double=0.0,
    @SerializedName("rating_top")
    var ratingTop: Double=0.0,
    @SerializedName("ratings_count")
    var ratingsCount: Int=0,
    @SerializedName("released")
    var released: String="",
    @SerializedName("reviews_text_count")
    var reviewsTextCount: String="",
    @SerializedName("slug")
    var slug: String="",
    @SerializedName("suggestions_count")
    var suggestionsCount: Int=0,
    @SerializedName("updated")
    var updated: String="",
    var liked:Int=0

)