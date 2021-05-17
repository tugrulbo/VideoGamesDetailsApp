package com.tugrulbo.gamedetails.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.squareup.picasso.Picasso
import com.tugrulbo.gamedetails.R
import com.tugrulbo.gamedetails.view.GameDetails
import com.tugrulbo.videogamesdatabase.model.Results
import kotlinx.android.synthetic.main.item_viewpager.view.*
import java.util.*

class ImageSliderAdapter(private val context: Context,private var videoGameList: ArrayList<Results>) : PagerAdapter() {


    private var inflater: LayoutInflater? = null
    private var slideCount = arrayOf(videoGameList[0].backgroundImage,videoGameList[1].backgroundImage,videoGameList[2].backgroundImage)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object`
    }

    override fun getCount(): Int {

        return slideCount.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {


        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater!!.inflate(R.layout.item_viewpager, null)
        var imageUrl = videoGameList[position].backgroundImage.toString()
        Picasso.get().load(imageUrl).into(view.imageView_slide)

        view.setOnClickListener(View.OnClickListener {
            var gameId = videoGameList[position].id
            val intent = Intent(context!!,GameDetails::class.java)
            intent.putExtra("gameId",gameId)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(context,intent,null)
        })

        val vp = container as ViewPager
        vp.addView(view, 0)
        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }

}