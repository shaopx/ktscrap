package com.spx.dev

open class Topic(val id:String, val title:String){
}

class PictureTopic(id:String, title:String, val pictures:Array<String> ) : Topic(id, title) {

}