# docgen-bundling-performance
Bundling Performance Test Automation Framework

## Build and run instructions

1. Get the build config from EM & Docgen team

2. Build
```
 FUNCTIONAL_TEST_CLIENT_S2S_TOKEN=XXXX FUNCTIONAL_TEST_CLIENT_OAUTH_SECRET=XXXX IDAM_API_BASE_URI=XXXX S2S_BASE_URI=XXXX IDAM_WEBSHOW_WHITELIST=XXXX baseURL=XXXX mvn gatling:test -Dgatling.simulationClass=uk.gov.hmcts.reform.docgen.bundling.simulation.CreateNewBundle

```

