package com.tugrulbo.videogamesdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tugrulbo.gamedetails.R
import com.tugrulbo.videogamesdatabase.model.Results
import kotlinx.android.synthetic.main.item_recyclerview.view.*
import java.util.*

class SearchAdapter(private var videoGameList: ArrayList<Results>, private var listener: Listener) : RecyclerView.Adapter<SearchAdapter.RowHolder>() {

    interface Listener{
        fun searchItemClick(results: ArrayList<Results>, position: Int){
        }
    }


    class RowHolder(view: View): RecyclerView.ViewHolder(view){

        fun bind(resultsArray: ArrayList<Results>, position: Int, listener:Listener){

            itemView.setOnClickListener{
                listener.searchItemClick(resultsArray,position)
            }
                if (position < resultsArray.size) {
                    itemView.itemName.text = resultsArray!![position]?.name.toString()
                    itemView.itemRating.text = resultsArray!![position]?.rating.toString()
                    itemView.itemReleased.text = resultsArray!![position]?.released.toString()
                    var imageURL = resultsArray!![position]?.backgroundImage.toString()
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