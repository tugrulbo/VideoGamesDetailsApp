package com.tugrulbo.gamedetails.model


import com.google.gson.annotations.SerializedName

data class GameDetailsModel(
    @SerializedName("achievements_count")
    var achievementsCount: Int,
    @SerializedName("added")
    var added: Int,
    @SerializedName("added_by_status")
    var addedByStatus: AddedByStatusX,
    @SerializedName("additions_count")
    var additionsCount: Int,
    @SerializedName("alternative_names")
    var alternativeNames: List<String>,
    @SerializedName("background_image")
    var backgroundİmage: String,
    @SerializedName("background_image_additional")
    var backgroundİmageAdditional: String,
    @SerializedName("clip")
    var clip: Any,
    @SerializedName("creators_count")
    var creatorsCount: Int,
    @SerializedName("description")
    var description: String,
    @SerializedName("description_raw")
    var descriptionRaw: String,
    @SerializedName("developers")
    var developers: List<Developer>,
    @SerializedName("dominant_color")
    var dominantColor: String,
    @SerializedName("esrb_rating")
    var esrbRating: EsrbRatingX,
    @SerializedName("game_series_count")
    var gameSeriesCount: Int,
    @SerializedName("genres")
    var genres: List<Genre>,
    @SerializedName("id")
    var id: Int,
    @SerializedName("metacritic")
    var metacritic: Int,
    @SerializedName("metacritic_platforms")
    var metacriticPlatforms: List<MetacriticPlatform>,
    @SerializedName("metacritic_url")
    var metacriticUrl: String,
    @SerializedName("movies_count")
    var moviesCount: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("name_original")
    var nameOriginal: String,
    @SerializedName("parent_achievements_count")
    var parentAchievementsCount: Int,
    @SerializedName("parent_platforms")
    var parentPlatforms: List<ParentPlatform>,
    @SerializedName("parents_count")
    var parentsCount: Int,
    @SerializedName("platforms")
    var platforms: List<PlatformXXXX>,
    @SerializedName("playtime")
    var playtime: Int,
    @SerializedName("publishers")
    var publishers: List<Publisher>,
    @SerializedName("rating")
    var rating: Double,
    @SerializedName("rating_top")
    var ratingTop: Int,
    @SerializedName("ratings")
    var ratings: List<Rating>,
    @SerializedName("ratings_count")
    var ratingsCount: Int,
    @SerializedName("reactions")
    var reactions: Any,
    @SerializedName("reddit_count")
    var redditCount: Int,
    @SerializedName("reddit_description")
    var redditDescription: String,
    @SerializedName("reddit_logo")
    var redditLogo: String,
    @SerializedName("reddit_name")
    var redditName: String,
    @SerializedName("reddit_url")
    var redditUrl: String,
    @SerializedName("released")
    var released: String,
    @SerializedName("reviews_count")
    var reviewsCount: Int,
    @SerializedName("reviews_text_count")
    var reviewsTextCount: Int,
    @SerializedName("saturated_color")
    var saturatedColor: String,
    @SerializedName("screenshots_count")
    var screenshotsCount: Int,
    @SerializedName("slug")
    var slug: String,
    @SerializedName("stores")
    var stores: List<Store>,
    @SerializedName("suggestions_count")
    var suggestionsCount: Int,
    @SerializedName("tags")
    var tags: List<Tag>,
    @SerializedName("tba")
    var tba: Boolean,
    @SerializedName("twitch_count")
    var twitchCount: Int,
    @SerializedName("updated")
    var updated: String,
    @SerializedName("user_game")
    var userGame: Any,
    @SerializedName("website")
    var website: String,
    @SerializedName("youtube_count")
    var youtubeCount: Int
)