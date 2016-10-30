package com.sf.model

import jdk.nashorn.internal.parser.JSONParser
import spray.json.{DefaultJsonProtocol, JsArray, JsString, JsValue, JsonWriter}

/**
  * Created by emi on 10/30/2016.
  */
case class Location (name:String, formatted_address:String, id:String, rating:Float = 0) {
  override def toString: String = {
    name + " - " + formatted_address + " - rating: " + rating
  }

}
object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val locationFormat = jsonFormat4(Location)
}




