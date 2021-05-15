package com.tugrulbo.gamedetails.fragments

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tugrulbo.gamedetails.R
import com.tugrulbo.gamedetails.adapter.ImageSliderAdapter
import com.tugrulbo.gamedetails.view.GameDetails
import com.tugrulbo.videogamesdatabase.adapter.ListAdapter
import com.tugrulbo.videogamesdatabase.model.GetListModel
import com.tugrulbo.videogamesdatabase.model.Results
import com.tugrulbo.videogamesdatabase.service.GetGames
import kotlinx.android.synthetic.main.fragment_home_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class HomePage : Fragment(), ListAdapter.Listener {

    //değişkenler
    private val baseUrl = "https://api.rawg.io/api/"
    private lateinit var gameListResults:ArrayList<Results>
    private var gameAdapter: ListAdapter?=null
    private var progressBar:DialogFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layoutManager: RecyclerView.LayoutManager=LinearLayoutManager(context)
        recyclerView?.layoutManager=layoutManager

        return inflater.inflate(R.layout.fragment_home_page, container, false)

    }

    private fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GetGames::class.java)
        val call = service.getVideoGamesData()

        call.enqueue(object: Callback<GetListModel>{
            override fun onResponse(call: Call<GetListModel>, response: Response<GetListModel>) {

                if(response.isSuccessful){

                    response.body().let {
                        gameListResults = ArrayList(it!!.results)

                        gameListResults.let {
                            gameAdapter= ListAdapter(it,this@HomePage)
                            val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
                            recyclerView?.layoutManager=layoutManager
                            recyclerView.adapter=gameAdapter
                            imageSliderImplementation()
                        }
                    }

                }
            }
            override fun onFailure(call: Call<GetListModel>, t: Throwable) {


            }


        })
    }

    private fun imageSliderImplementation() {
        val adapter = ImageSliderAdapter(context!!.applicationContext,gameListResults)
        viewPagerMain.adapter = adapter
    }

    override fun onItemClick(results: ArrayList<Results>, position:Int) {
        var gameId = results[position+3].id
        Toast.makeText(context!!,"${results[position+3].name}",Toast.LENGTH_LONG).show()
        val intent = Intent(context!!,GameDetails::class.java)
        intent.putExtra("gameId",gameId)
        startActivity(intent)
    }


}