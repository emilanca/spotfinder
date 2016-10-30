package com.sf.model

import jdk.nashorn.internal.parser.JSONParser

/**
  * Created by emi on 10/30/2016.
  */
case class Location (name:String, formatted_address:String, id:String, rating:Float = 0) {
  override def toString:String = {
    name + " - " + formatted_address + " - rating: " + rating
  }
  def toJsonString:String = {
    "{ \"name\": " + name + " \", \"name\": " + formatted_address + " \"}"
  }
}




