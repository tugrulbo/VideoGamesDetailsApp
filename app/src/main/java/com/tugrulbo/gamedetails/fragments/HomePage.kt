package com.tugrulbo.gamedetails.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tugrulbo.gamedetails.R
import com.tugrulbo.gamedetails.adapter.ImageSliderAdapter
import com.tugrulbo.gamedetails.dbhelpers.DBHelper
import com.tugrulbo.gamedetails.view.GameDetails
import com.tugrulbo.videogamesdatabase.adapter.ListAdapter
import com.tugrulbo.videogamesdatabase.adapter.SearchAdapter
import com.tugrulbo.videogamesdatabase.model.GetListModel
import com.tugrulbo.videogamesdatabase.model.Results
import com.tugrulbo.videogamesdatabase.service.GetGames
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.fragment_home_page.searchText
import kotlinx.android.synthetic.main.fragment_liked.*
import kotlinx.android.synthetic.main.item_recyclerview.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class HomePage : Fragment(), ListAdapter.Listener, SearchAdapter.Listener {

    //değişkenler
    private val baseUrl = "https://api.rawg.io/api/"
    private lateinit var gameListResults:ArrayList<Results>
    private lateinit var searcListResults:ArrayList<Results>
    private var gameAdapter: ListAdapter?=null
    private var searchAdapter: SearchAdapter?=null
    var i :Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home_page, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var db = DBHelper(context)
        var data = db.readData()

        searchText.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if(MotionEvent.ACTION_UP == event?.action){
                    viewPagerMain.visibility = View.GONE
                    recyclerView.visibility = View.GONE
                    databaseSearch.visibility = View.VISIBLE
                    searchText.addTextChangedListener(object : TextWatcher{
                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) {



                        }

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {

                        }

                        override fun afterTextChanged(s: Editable?) {
                            try {
                                if(s!!.length>=3){

                                    filterList(s.toString(),data)

                                }
                            }catch (e:java.lang.Exception){

                            }
                        }

                    })

                }
                return true
            }

        })

    }

    private fun filterList(s:String,data:ArrayList<Results>){

        var j :Int =0
        var tempList: ArrayList<Results> = ArrayList()
        while (j<data.size){
            if (data[j].name!!.toLowerCase().toString().contains(s)){
                tempList.add(data[j])
                j++
            }else{
                j++
            }
        }
        tempList.let {
            searcListResults = ArrayList(it)
            searcListResults.let {
                searchAdapter= SearchAdapter(it,this@HomePage)
                val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
                databaseSearch?.layoutManager=layoutManager
                databaseSearch.adapter=searchAdapter
            }
        }
        searchAdapter?.updateList(tempList)
        searchAdapter?.notifyDataSetChanged()

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
                            manageDatabase(gameListResults)

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
        val intent = Intent(context!!,GameDetails::class.java)
        intent.putExtra("gameId",gameId)
        startActivity(intent)
    }

    override fun searchItemClick(results: ArrayList<Results>, position:Int) {
        var gameId = results[position].id
        val intent = Intent(context!!,GameDetails::class.java)
        intent.putExtra("gameId",gameId)
        startActivity(intent)
    }

    private fun manageDatabase(results: ArrayList<Results>){
        try {
            var db = DBHelper(context)
           while (i<results.size){
               db.insertData(results,i)
                i++
            }
            i=0



        }catch (e: Exception){
            e.printStackTrace()
        }
    }






}