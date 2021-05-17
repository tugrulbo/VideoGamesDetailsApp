package com.tugrulbo.videogamesdatabase.service

import com.tugrulbo.gamedetails.model.GameDetailsModel
import com.tugrulbo.videogamesdatabase.model.GetListModel
import com.tugrulbo.videogamesdatabase.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface GetGames {


    @GET(value = "games?key=KEY")
    fun getVideoGamesData(): Call<GetListModel>

    @GET(value= "{id}?key=KEY")
    fun getGamesDetails(@Path("id") gameId:Int?): Call<GameDetailsModel>
}