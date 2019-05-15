package com.svastrad.adEnhancer;

import com.svastrad.adEnhancer.model.Publisher;
import com.svastrad.adEnhancer.model.Site;
import com.svastrad.adEnhancer.service.PublisherService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class PublisherServiceTest {
    RestTemplateBuilder builder;
    @Before
    public void setUp() throws Exception {
        builder = new RestTemplateBuilder();
    }

    @Test
    public void testPubService() throws ExecutionException, InterruptedException {
        PublisherService publisherService = new PublisherService(builder);
        Site site = new Site();
        site.setId("123");
        site.setPage("123");

        CompletableFuture<Publisher> publisher = publisherService.injectPublisher(site);
        CompletableFuture.allOf(publisher).join();

        System.out.println("name: " + publisher.get().getName());
        System.out.println("id: " + publisher.get().getId());

    }
}