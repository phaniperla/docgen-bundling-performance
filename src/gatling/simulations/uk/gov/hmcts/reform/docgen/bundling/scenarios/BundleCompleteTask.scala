package simulations.uk.gov.hmcts.reform.docgen.bundling.scenarios
import io.gatling.http.Predef.{http, status}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import simulations.uk.gov.hmcts.reform.docgen.bundling.util.TestUtil

object BundleCompleteTask {

  val taskID = "123"
  val testUtil = new TestUtil()

  val completeBundleTask = http("Complete Bundle Task")
    .get(s"api/document-tasks/${taskID}")
    .header("Authorization", testUtil.getIdamAuth())
    .header("ServiceAuthorization", testUtil.getS2sAuth())
    .header("Content-Type", "application/json")
    .check(status is 200)

  val getUser = scenario("Complete Bundle Creation")
    .exec(completeBundleTask)

}
