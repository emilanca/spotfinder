package com.sf.connector.google
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
/**
  * Created by emi on 10/30/2016.
  */
class GooglePlacesApiConnectorTest extends FunSuite with BeforeAndAfter{

  var googleConnector : GooglePlacesApiConnector = _
  before {
    googleConnector = new GooglePlacesApiConnector
  }
  test ("Connector gets data...") {
    assert(googleConnector.getLocationData("McDonalds").nonEmpty)
  }
}
