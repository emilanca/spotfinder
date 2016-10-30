package com.sf.webservice

import akka.actor.Actor
import com.sf.connector.google.GooglePlacesApiConnector
import spray.routing._
import spray.http._
import MediaTypes._
import spray.json.{JsString, _}
import DefaultJsonProtocol._
import com.sf.model.MyJsonProtocol._




// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MyServiceActor extends Actor with MyService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute~placesRoute)

}


// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {

  val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Spotfinder poc</h1>
              </body>
            </html>
          }
        }
      }
    }

  val placesRoute =
    path("places") {
      get {
        parameters('search_term) {
          search_term =>
            respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
              clientIP {
                ip =>
                  val prettyip = ip.toOption.map(_.getHostAddress).getOrElse("78.97.211.14")
                  val placesConnector = new GooglePlacesApiConnector(sourceIp = "78.97.211.145")
                  val results = placesConnector.getNearbyLocationData(search_term)

                  //complete(results.head.toJson.prettyPrint)
                  complete(s"${results.map(x=>x.toJson) mkString ",\n"}")

              }
            }
        }

      }
    }
}



