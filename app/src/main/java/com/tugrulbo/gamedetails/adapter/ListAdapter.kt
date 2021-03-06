package com.tugrulbo.videogamesdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tugrulbo.gamedetails.R
import com.tugrulbo.videogamesdatabase.model.Results
import kotlinx.android.synthetic.main.fragment_home_page.view.*
import kotlinx.android.synthetic.main.item_recyclerview.view.*
import java.util.*

class ListAdapter(private var videoGameList: ArrayList<Results>, private var listener: Listener) : RecyclerView.Adapter<ListAdapter.RowHolder>() {

    interface Listener{
        fun onItemClick(results: ArrayList<Results>, position: Int){
        }
    }


    class RowHolder(view: View): RecyclerView.ViewHolder(view){

        fun bind(resultsArray: ArrayList<Results>, position: Int, listener:Listener){

            itemView.setOnClickListener{
                listener.onItemClick(resultsArray,position)
            }
                if (position+3 < (resultsArray.size)-1) {
                    itemView.itemName.text = resultsArray!![position+3]?.name.toString()
                    itemView.itemRating.text = resultsArray!![position+3]?.rating.toString()
                    itemView.itemReleased.text = resultsArray!![position+3]?.released.toString()
                    var imageURL = resultsArray!![position+3]?.backgroundImage.toString()
                    Picasso.get().load("${imageURL}").resize(90, 80).centerCrop()
                        .into(itemView.itemImage);


                }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview,parent,false)

        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return videoGameList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        holder.bind(videoGameList,position,listener)

    }

     fun updateList(list:ArrayList<Results>){
        videoGameList = list
        notifyDataSetChanged()
    }



}