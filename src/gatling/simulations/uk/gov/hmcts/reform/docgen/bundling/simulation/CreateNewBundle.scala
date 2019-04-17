package simulations.uk.gov.hmcts.reform.docgen.bundling.simulation
import io.gatling.core.Predef._
import io.gatling.core.Predef.{global, rampUsers}
import io.gatling.http.Predef.{Proxy, http}
import simulations.uk.gov.hmcts.reform.docgen.bundling.scenarios.CreateBundle
import simulations.uk.gov.hmcts.reform.docgen.bundling.util.{Environment, Headers}

import scala.concurrent.duration._

class CreateNewBundle extends Simulation{

  val httpConf = http
    .proxy(Proxy("proxyout.reform.hmcts.net", 8080))
    .baseUrl(Environment.baseURL)
    .headers(Headers.commonHeader)

  val createBundleScenarios = List (
    CreateBundle.postUser.inject(
      rampUsers(1) during(1 seconds)
    )
  )

  setUp(createBundleScenarios)
    .protocols(httpConf)
    .maxDuration(1 minutes)
    .assertions(
      global.responseTime.max.lt(Environment.maxResponseTime.toInt)
    )
}
