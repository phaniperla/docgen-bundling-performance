package simulations.uk.gov.hmcts.reform.docgen.bundling.scenarios
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import play.api.libs.json.{JsValue, Json}
import simulations.uk.gov.hmcts.reform.docgen.bundling.util.TestUtil

import scala.io.Source

object StitchBundle {
  val testUtil = new TestUtil();
  val source: String = Source.fromFile("src/resources/stitch_bundle.json").getLines.mkString
  val json: JsValue = Json.parse(source)

  val postStitchBundle = http("Stitch Bundle")
    .post("/api/stitch-ccd-bundles")
    .header("Authorization", testUtil.getIdamAuth())
    .header("ServiceAuthorization", testUtil.getS2sAuth())
    .header("Content-Type", "application/json")
    .body(StringBody(json.toString()))
    .check(status is 200)

  val postUser = scenario("Stitch Bundle")
    .exec(postStitchBundle)
    .exec { session => println(session("responseBody").as[String]); session}

}
