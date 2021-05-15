package com.tugrulbo.videogamesdatabase.service

import com.tugrulbo.gamedetails.model.GameDetailsModel
import com.tugrulbo.videogamesdatabase.model.GetListModel
import com.tugrulbo.videogamesdatabase.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface GetGames {


    @GET(value = "games?key=d2a9c4ecd4884d768f3ed82b573f8dec")
    fun getVideoGamesData(): Call<GetListModel>

    @GET(value= "{id}?key=d2a9c4ecd4884d768f3ed82b573f8dec")
    fun getGamesDetails(@Path("id") gameId:Int?): Call<GameDetailsModel>
}