package simulations.uk.gov.hmcts.reform.docgen.bundling.scenarios
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import simulations.uk.gov.hmcts.reform.docgen.bundling.util.TestUtil

object createBundleTask {

  val testUtil = new TestUtil();
  val bodyString = "{\"createdDate\":1554983257.163000000,\"lastModifiedDate\":1554983257.163000000,\"bundle\":{\"createdDate\":1554983256.573000000,\"lastModifiedDate\":1554983256.573000000,\"bundleTitle\":\"Bundle Title\",\"description\":\"This is the description of the bundle: it is great.\",\"documents\":[{\"createdDate\":1554983256.953000000,\"lastModifiedDate\":1554983256.953000000,\"docTitle\":\"Title (Document1.pdf)\",\"docDescription\":\"Description (Document1.pdf)\",\"documentURI\":\"http://dm-store-aat.service.core-compute-aat.internal/documents/b5aff524-4881-4485-b3f5-38d622363826\",\"sortIndex\":2},{\"createdDate\":1554983257.162000000,\"lastModifiedDate\":1554983257.162000000,\"docTitle\":\"Title (Document2.pdf)\",\"docDescription\":\"Description (Document2.pdf)\",\"documentURI\":\"http://dm-store-aat.service.core-compute-aat.internal/documents/e33e16e0-52c0-4794-9ab6-f93fc60ad06c\",\"sortIndex\":1}]}}"

  val createBundle = http("Create Bundle Task")
    .post("api/document-tasks")
    .header("Authorization", testUtil.getIdamAuth())
    .header("ServiceAuthorization", testUtil.getS2sAuth())
    .body(StringBody(bodyString))
    .header("Content-Type", "application/json")
    .check(status is 201)

  val postUser = scenario("Stitch Bundle New")
    .exec(createBundle)
}
