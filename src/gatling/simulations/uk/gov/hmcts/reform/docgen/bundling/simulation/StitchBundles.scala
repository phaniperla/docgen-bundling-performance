package uk.gov.hmcts.reform.docgen.bundling.simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import simulations.uk.gov.hmcts.reform.docgen.bundling.util.{Environment, Headers}
import simulations.uk.gov.hmcts.reform.docgen.scenarios.createBundleTask

import scala.concurrent.duration._

class StitchBundles extends Simulation{

  val httpConf = http
    .proxy(Proxy("proxyout.reform.hmcts.net", 8080))
    .baseUrl(Environment.baseURL)
    .headers(Headers.commonHeader)

  val stitchBundleScenarios = List (
    createBundleTask.postUser.inject(
      rampUsers(1) during(1 seconds)
    )
  )

  setUp(stitchBundleScenarios)
    .protocols(httpConf)
    .maxDuration(1 minutes)
    .assertions(
      global.responseTime.max.lt(Environment.maxResponseTime.toInt)
    )
}