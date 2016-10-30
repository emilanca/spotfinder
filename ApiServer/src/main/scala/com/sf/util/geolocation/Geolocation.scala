package com.sf.util.geolocation

import java.io.File

import com.maxmind.geoip.{LookupService, Location}

/**
  * Created by emi on 10/30/2016.
  */

class Geolocation (ipAddress:String) {
  val latLong:LatLong = {
    val cl : LookupService  = new LookupService( new File("src/main/resources/geocode/GeoLiteCity.dat"),
      LookupService.GEOIP_MEMORY_CACHE | LookupService.GEOIP_CHECK_CACHE)
    val location : Location = cl.getLocation(ipAddress)
    LatLong(location.latitude.toString,location.longitude.toString)
  }

}
case class LatLong(lat:String,long:String)
