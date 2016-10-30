package com.sf.connector

import com.sf.model.Location
import com.sf.util.geolocation.{Geolocation, LatLong}

/**
  * Created by emi on 10/30/2016.
  */
trait ApiConnector {

  val geoLocation : Geolocation
  def getLocationData (searchKey : String): List[Any]
  def getNearbyLocationData(searchKey: String, latLong: LatLong): List[Any]
  def getLocationDetails(locationId:String) : Location

}
