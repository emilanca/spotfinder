package com.sf.model

/**
  * Created by emi on 10/30/2016.
  */
class Location (name:String, formatted_address:String, id:String, rating:Int = 0) {
  override def toString:String = {
    name + " - " + formatted_address + " - rating: " + rating
  }
}


