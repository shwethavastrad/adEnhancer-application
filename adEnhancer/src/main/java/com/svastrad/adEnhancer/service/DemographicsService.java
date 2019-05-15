package com.svastrad.adEnhancer.service;

import com.svastrad.adEnhancer.model.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@Service("demographicsService")
public class DemographicsService {
    private final RestTemplate restTemplate;

    public DemographicsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    @Async
    public CompletableFuture<Demographics> injectDemographics(@Valid Site site) {

        final String uri = "http://159.89.185.155:3000/api/sites/"+site.getId()+"/demographics";

        DemographicsResponse result = null;

        try {
            result = this.restTemplate.getForObject(uri, DemographicsResponse.class);
        } catch (Exception e) {

        }

        return result != null ? CompletableFuture.completedFuture(result.getDemographics()): null;

    }
}
