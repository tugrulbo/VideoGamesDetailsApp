package com.tugrulbo.gamedetails.model

class SearchModel {
    var gameName:String?=null
    var gameId:Int? =0

    constructor(gameName:String?,gameId:Int?){
        this.gameName = gameName
        this.gameId = gameId
    }
    constructor()

}