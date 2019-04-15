package uk.gov.hmcts.reform.docgen.bundling.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.docgen.bundling.util.TestUtil

import scala.io.Source

object CreateBundle {

  val testUtil = new TestUtil();
 // File jsonFile = new File(ClassLoader.getSystemResource("case.json").getPath);

  val source: String = Source.fromFile("src/resources/case.json").getLines.mkString
  val json: JsValue  =


  val postCreateBundleReq = http("New Bundle")
    .post("/api/new-bundle")
    .header("Authorization", testUtil.getIdamAuth())
    .header("ServiceAuthorization", testUtil.getS2sAuth())
    .body(StringBody(jsonFile))
    .header("Content-Type", "application/json")
    .check(status is 200)
}
