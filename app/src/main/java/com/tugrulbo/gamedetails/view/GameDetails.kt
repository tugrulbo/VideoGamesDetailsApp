package com.tugrulbo.gamedetails.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import com.tugrulbo.gamedetails.R
import com.tugrulbo.gamedetails.dbhelpers.DBHelper
import com.tugrulbo.gamedetails.model.GameDetailsModel
import com.tugrulbo.videogamesdatabase.service.GetGames
import kotlinx.android.synthetic.main.activity_game_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameDetails : AppCompatActivity() {

    var gameId:Int?=null

    //değişkenler
    private val baseUrl = "https://api.rawg.io/api/games/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_details)
        gameId = intent.getIntExtra("gameId",0)
        loadData()
    }

    private fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GetGames::class.java)
        val call = service.getGamesDetails(gameId)

        call.enqueue(object: Callback<GameDetailsModel> {
            override fun onResponse(call: Call<GameDetailsModel>, response: Response<GameDetailsModel>) {

                if(response.isSuccessful){
                    var result = response.body()
                    var imageUrl = result?.backgroundİmage.toString()
                    Picasso.get().load(imageUrl).into(gameDetails_image)

                    gameDetails_name.text = result?.name.toString()
                    gameDetails_release.text = result?.released.toString()
                    gameDetails_metacritic.text = result?.metacritic.toString()
                    gameDetails_desc.text = result?.descriptionRaw.toString()
                }
            }
            override fun onFailure(call: Call<GameDetailsModel>, t: Throwable) {


            }


        })
    }

    fun likeImage(view: View) {
        gameId = intent.getIntExtra("gameId",0)
        var db = DBHelper(this)
        db.updateData(gameId!!)
    }
}