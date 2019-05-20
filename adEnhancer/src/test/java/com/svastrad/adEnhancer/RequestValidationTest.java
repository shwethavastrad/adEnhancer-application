package com.svastrad.adEnhancer;

import com.svastrad.adEnhancer.config.TestConfig;
import com.svastrad.adEnhancer.model.AdRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AdEnhancerApplication.class, TestConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestValidationTest {


    int port = 8100;


    @Before
    public void init() {

        RestAssured.port = port;
        RestAssured.baseURI = "http://127.0.0.1:8765/ad-enhancer-service/";
    }

    @Test
    public void givenApiRequest_whenLocationForbidden_shouldSendForbiddenResponse() {
        String requestJson = "{\n" +
                "\"site\": {\n" +
                "\"id\": \"foo123\",\n" +
                "\"page\": \"http://www.foo.com/why-foo\" },\n" +
                "\"device\": {\n" +
                "\"ip\": \"69.250.196.118\"\n" +
                "}, \n" +
                "\"user\": {\n" +
                "\"id\": \"9cb89r\" }\n" +
                "}\n";
        final Response response = given()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                .header("X-Forwarded-For", "88.198.50.103") // Nuremberg
                .header("Content-Type", "application/json")
                .body(requestJson)
                .post("/enhance");

        Assert.assertEquals(403, response.statusCode());
    }

    @Test
    public void givenApiRequest_whenLocationValid_shouldSendValidResponse() {

        String requestJson = "{\n" +
                "\"site\": {\n" +
                "\"id\": \"foo123\",\n" +
                "\"page\": \"http://www.foo.com/why-foo\" },\n" +
                "\"device\": {\n" +
                "\"ip\": \"69.250.196.118\"\n" +
                "}, \n" +
                "\"user\": {\n" +
                "\"id\": \"9cb89r\" }\n" +
                "}\n";
        final Response response = given()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                .header("X-Forwarded-For", "69.250.196.118") // US
                .header("Content-Type", "application/json")
                .body(requestJson)
                .post("/enhance");
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void givenApiRequest_whenPublisherNotFound_shouldAbort() {
        String requestJson = "{\n" +
                "\"site\": null,\n" +
                "\"device\": {\n" +
                "\"ip\": \"69.250.196.118\"\n" +
                "}, \n" +
                "\"user\": {\n" +
                "\"id\": \"9cb89r\" }\n" +
                "}\n";
        final Response response = given()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                .header("X-Forwarded-For", "69.250.196.118") // US
                .header("Content-Type", "application/json")
                .body(requestJson)
                .post("/enhance");

        Assert.assertEquals(400, response.statusCode());
    }

    @Test
    public void givenApiRequest_whenPublisherFound_sendResponse() {
        String requestJson = "{\n" +
                "\"site\": {\n" +
                "\"id\": \"foo123\",\n" +
                "\"page\": \"http://www.foo.com/why-foo\" },\n" +
                "\"device\": {\n" +
                "\"ip\": \"69.250.196.118\"\n" +
                "}, \n" +
                "\"user\": {\n" +
                "\"id\": \"9cb89r\" }\n" +
                "}\n";
        final Response response = given()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                .header("X-Forwarded-For", "69.250.196.118") // US
                .header("Content-Type", "application/json")
                .body(requestJson)
                .post("/enhance");

        Assert.assertEquals(200, response.statusCode());
        Assert.assertNotNull(response.getBody().as(AdRequest.class).getSite().getPage());
    }

    @Test
    public void givenApiRequest_whenRequestInvalid_sendErrorResponse() {
        String requestJson = "{\n" +
                "\"site\": {\n" +
                "\"id\": \"foo123\",\n" +
                "\"page\": \"http://www.foo.com/why-foo\" },\n" +
                "\"device\": null, \n" +
                "\"user\": {\n" +
                "\"id\": \"9cb89r\" }\n" +
                "}\n";
        final Response response = given()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                .header("X-Forwarded-For", "69.250.196.118") // US
                .header("Content-Type", "application/json")
                .body(requestJson)
                .post("/enhance");

        Assert.assertEquals(400, response.statusCode());
    }
}
