package com.svastrad.adEnhancer;

import com.svastrad.adEnhancer.model.AdRequest;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

public class AdEnhanceControllerTest {

    @Test
    public void enhanceAdRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-Forwarded-For", "88.198.50.103");

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
        String uri = "http://127.0.0.1:8765/ad-enhancer-service/enhance";
        RestTemplate template = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);


        HttpEntity<AdRequest> result = template.postForEntity(uri, entity, AdRequest.class);
        Assert.notNull(result.getBody());
    }
}