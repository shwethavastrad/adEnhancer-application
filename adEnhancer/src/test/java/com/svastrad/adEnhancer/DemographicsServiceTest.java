package com.svastrad.adEnhancer;

import com.svastrad.adEnhancer.model.Demographics;
import com.svastrad.adEnhancer.model.Site;
import com.svastrad.adEnhancer.service.DemographicsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class DemographicsServiceTest {
    RestTemplateBuilder builder;
    @Before
    public void setUp() throws Exception {
        builder = new RestTemplateBuilder();
    }

    @Test
    public void testPubService() throws ExecutionException, InterruptedException {
        DemographicsService demographicsService = new DemographicsService(builder);
        Site site = new Site();
        site.setId("123");
        site.setPage("123");

        CompletableFuture<Demographics> demographics = demographicsService.injectDemographics(site);
        CompletableFuture.allOf(demographics).join();

        System.out.println("female: " + demographics.get().getPctFemale());

    }

}