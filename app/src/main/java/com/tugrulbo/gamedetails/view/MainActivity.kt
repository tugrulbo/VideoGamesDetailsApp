package com.tugrulbo.gamedetails.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tugrulbo.gamedetails.R
import com.tugrulbo.gamedetails.fragments.HomePage
import com.tugrulbo.gamedetails.fragments.Liked
import com.tugrulbo.gamedetails.fragments.adapter.ViewPager
import com.tugrulbo.videogamesdatabase.adapter.ImageSliderAdapter
import com.tugrulbo.videogamesdatabase.adapter.ListAdapter
import com.tugrulbo.videogamesdatabase.model.GetListModel
import com.tugrulbo.videogamesdatabase.model.Results
import com.tugrulbo.videogamesdatabase.service.GetGames
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity(), ListAdapter.Listener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupTabs()

    }


    private fun setupTabs(){
        val adapter = ViewPager(supportFragmentManager)
        adapter.addFragment(HomePage(),"")
        adapter.addFragment(Liked(),"")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.homepage)
        tabs.getTabAt(1)!!.setIcon(R.drawable.liked)
    }


}