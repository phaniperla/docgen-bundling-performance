package simulations.uk.gov.hmcts.reform.docgen.bundling.scenarios
import play.api.libs.json.{JsValue, Json}

import scala.io.Source

object Main {
  def main(args: Array[String]) {
    println( "Returned Value : " );
  }
  val source: String = Source.fromFile("src/resources/case.json").getLines.mkString
  val json: JsValue = Json.parse(source)
  print(json)
}