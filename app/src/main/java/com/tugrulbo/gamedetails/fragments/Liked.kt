package com.tugrulbo.gamedetails.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.tugrulbo.gamedetails.R
import com.tugrulbo.gamedetails.dbhelpers.DBHelper
import com.tugrulbo.gamedetails.view.GameDetails
import com.tugrulbo.videogamesdatabase.adapter.LikedAdapter
import com.tugrulbo.videogamesdatabase.model.Results
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.fragment_liked.*
import java.util.*


class Liked : Fragment(), LikedAdapter.Listener {

    private lateinit var gameListResults:ArrayList<Results>
    private var likedAdapter: LikedAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_liked, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerViewLiked?.layoutManager=layoutManager
        recyclerViewLiked.adapter=likedAdapter

        loadData()
        swipeContainer.setOnRefreshListener(object: SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                loadData()
                swipeContainer.setRefreshing(false);
            }
        })
    }

    private fun loadData(){
        var db = DBHelper(context)
        var data = db.readData()
        var j :Int =0
        var tempList: ArrayList<Results> = ArrayList()
        Log.println(Log.INFO, "data", data.size.toString())
        while (j<data.size){
            if (data[j].liked!! == 1){
                tempList.add(data[j])
                j++
            }else{
                j++
            }
        }

        tempList.let {
            gameListResults = ArrayList(it)
            gameListResults.let {
                likedAdapter= LikedAdapter(it,this@Liked)
                val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
                recyclerViewLiked?.layoutManager=layoutManager
                recyclerViewLiked.adapter=likedAdapter
            }
        }

        likedAdapter?.updateList(tempList)
        likedAdapter?.notifyDataSetChanged()

    }


    override fun onItemClick(results: ArrayList<Results>, position:Int) {
        var gameId = results[position].id
        val intent = Intent(context!!, GameDetails::class.java)
        intent.putExtra("gameId",gameId)
        startActivity(intent)
    }
}