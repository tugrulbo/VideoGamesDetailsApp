package com.tugrulbo.gamedetails.dbhelpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.tugrulbo.gamedetails.model.SearchModel
import com.tugrulbo.videogamesdatabase.model.Results
import java.util.*


val databaseName = "VideoGamesFull19"
val tableName = "videogamesdenemesi"
val gameName = "gameName"
val gameId="gameId"
val gameSlug = "gameSlug"
val backgroundImage="backgroundImage"
val gameRating ="gameRating"
val gameReleased ="gameReleased"
val liked="liked"
val id="id"

class DBHelper(var context:Context?):SQLiteOpenHelper(context, databaseName,null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        var createTable = "CREATE TABLE IF NOT EXISTS "+ tableName+"(id INTEGER PRIMARY KEY AUTOINCREMENT, "+ gameId+" INTEGER, "+ gameName+" VARCHAR(256), "+gameSlug+" VARCHAR(256), "+gameRating+" DOUBLE,"+ gameReleased+" VARCHAR(256), "+ backgroundImage+" VARCHAR(256),"+ liked+" INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(results: ArrayList<Results>,position:Int){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(gameId,results[position].id.toInt())
        cv.put(gameName,results[position].name.toString())
        cv.put(gameSlug,results[position].slug.toString())
        cv.put(gameRating,results[position].rating.toDouble())
        cv.put(gameReleased,results[position].released.toString())
        cv.put(backgroundImage,results[position].backgroundImage.toString())
        cv.put(liked,results[position].liked.toInt())
        var result = db.insert(tableName,null,cv)
        if(result == (-1).toLong()){
                Toast.makeText(context,"Hatalı",Toast.LENGTH_SHORT).show()
        }else{
            //Toast.makeText(context,"Başarılı",Toast.LENGTH_SHORT).show()
        }
    }

    fun readData(): ArrayList<Results> {
        var readList : ArrayList<Results> = ArrayList()
        val db = this.readableDatabase
        var query = "SELECT * FROM "+ tableName
        var result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var tempResults = Results()
                var name = result.getString(result.getColumnIndex(gameName))
                var id = result.getString(result.getColumnIndex(gameId)).toInt()
                var image = result.getString(result.getColumnIndex(backgroundImage))
                var released = result.getString(result.getColumnIndex(gameReleased))
                var rating = result.getString(result.getColumnIndex(gameRating))
                var liked = result.getString(result.getColumnIndex(liked))
                tempResults.name=name.toString()
                tempResults.id=id.toInt()
                tempResults.backgroundImage = image.toString()
                tempResults.released = released.toString()
                tempResults.rating =rating.toDouble()
                tempResults.liked = liked.toInt()
                if(tempResults !=null){
                    readList.add(tempResults)
                }


            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return readList
    }

    fun updateData(gameid:Int){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(liked,1)
        db.update(tableName,cv,"gameId="+ gameid,null)
        db.close()

    }
}