package uk.gov.hmcts.reform.docgen.bundling.scenarios
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.docgen.bundling.util.TestUtil

object createNewBundle {
  val testUtil = new TestUtil();

  println("IDAM Token-->:" + testUtil.getIdamAuth())
  println("S2S Token-->:" + testUtil.getS2sAuth())

  val getUserHttp= http("Form Definition")
    .get(s"/api/form-definitions/${testUtil.getTemplateID()}")
    .header("Authorization", testUtil.getIdamAuth())
    .header("ServiceAuthorization", testUtil.getS2sAuth())
    .header("Content-Type", "application/json")
    .check(status is 200)

  val getRequest = scenario("Template Definition")
    .exec(getUserHttp)

}
