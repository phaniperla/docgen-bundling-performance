package simulations.uk.gov.hmcts.reform.docgen.bundling.scenarios
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import play.api.libs.json.{JsValue, Json}
import simulations.uk.gov.hmcts.reform.docgen.bundling.util.{DMHelper, TestUtil}

import scala.io.Source

object StitchBundle {

  val testUtil = new TestUtil();

  def prepareJson( pathToUnpreparedJson:String, pathToPdfDocument:String ) : JsValue = {
    val documentUri:String = DMHelper.uploadDocument(pathToPdfDocument)
    println("JJJ - documentURI is ")
    println(documentUri)
    val unpreparedJson:String = Source.fromFile(pathToUnpreparedJson).getLines.mkString
    val jsonWithDocumentUri:String = unpreparedJson.format(documentUri)
    println("JJJ - completed Json is ")
    println(jsonWithDocumentUri)
    val preparedJson:JsValue = Json.parse(jsonWithDocumentUri)
    return preparedJson
  }

//  val postStitchBundle = http("Stitch Bundle")
//    .post("/api/stitch-ccd-bundles")
//    .header("Authorization", testUtil.getIdamAuth())
//    .header("ServiceAuthorization", testUtil.getS2sAuth())
//    .header("Content-Type", "application/json")
//    .body(StringBody(prepareJson("src/resources/stitch_bundle.json", "src/resources/annotationTemplate.pdf").toString()))
//    .check(status is 200)

  val postUser = scenario("Stitch Bundle")
    //.exec(dmHelper.uploadDocument("src/resources/annotationTemplate.pdf"))
    .exec(prepareJson("src/resources/stitch_bundle.json", "src/resources/annotationTemplate.pdf"))
}
