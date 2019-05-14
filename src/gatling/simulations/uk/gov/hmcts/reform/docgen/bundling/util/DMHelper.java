package simulations.uk.gov.hmcts.reform.docgen.bundling.util;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.http.MediaType;

public class DMHelper {
    TestUtil testUtil = new TestUtil();

    public String uploadDocument(String pdfName) {
        String url = new String("Example doc URI");
        return url;
//        String url = s2sAuthRequest()
//                .header("ServiceAuthorization", testUtil.getS2sAuth())
//                .header("Content-Type", MediaType.MULTIPART_FORM_DATA_VALUE)
//                .multiPart("files", "test.pdf", ClassLoader.getSystemResourceAsStream(pdfName), "application/pdf")
//                .multiPart("classification", "PUBLIC")
//                .request("POST", Env.getDmStoreAppUrl() + "/documents")
//                .getBody()
//                .jsonPath()
//                .get("_embedded.documents[0]._links.self.href");
//
//        System.out.println("JJJ response from DM is");
//        System.out.println(url);
//        return url;
    }

//    public RequestSpecification s2sAuthRequest() {
//        return RestAssured
//                .given()
//                .header("ServiceAuthorization", testUtil.getS2sAuth());
//    }
}
