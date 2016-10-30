package com.sf.connector.google

import java.net.InetAddress

import com.google.maps.model.{PlacesSearchResult, LatLng}
import com.google.maps._
import com.sf.connector.ApiConnector
import com.sf.model.Location
import com.sf.util.geolocation.{LatLong, Geolocation}
import com.typesafe.config.ConfigFactory

/**
  * Created by emi on 10/30/2016.
  */
class GooglePlacesApiConnector(val sourceIp:String="") extends ApiConnector{

  var context: GeoApiContext = new GeoApiContext().setApiKey("AIzaSyC3UrBc-V3kY86Du26_yA_hz419QDYD8ak")

  def getLocationData (searchKey : String): List[PlacesSearchResult] = {
    PlacesApi.textSearchQuery(context,searchKey).await().results.toList
  }

  override def getNearbyLocationData(searchKey: String, latLong: LatLong = geoLocation.latLong): List[PlacesSearchResult] = {
    val currentLatLng = buildLatLong(latLong.lat, latLong.long)
    PlacesApi.textSearchQuery(context, searchKey).location(currentLatLng).radius(5000).await().results.toList
  }

  override def getLocationDetails(locationId: String): Location = {
    val placeDetails = PlacesApi.placeDetails(context, locationId).await()
    new Location(placeDetails.name, placeDetails.formattedAddress, locationId, placeDetails.rating.toInt)
  }

  def buildLatLong(lat:String,long:String) : LatLng = {
    new LatLng(lat.toDouble, long.toDouble)
  }

  override val geoLocation: Geolocation = new Geolocation(sourceIp)
}

object Runner{
  def main(args: Array[String]) {
    val placesConnector = new GooglePlacesApiConnector(sourceIp = "78.97.211.145")
    val results = placesConnector.getNearbyLocationData("KFC")
    results foreach {
      res =>
        println(res.name + " - " + res.formattedAddress)
    }
  }
}

