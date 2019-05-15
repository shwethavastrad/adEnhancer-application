package com.svastrad.adEnhancer.service;

import com.svastrad.adEnhancer.error.PublisherNotFoundException;
import com.svastrad.adEnhancer.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Service("publisherService")
public class PublisherService {
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(PublisherService.class);

    public PublisherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<Publisher> injectPublisher(@Valid Site site) throws PublisherNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final String uri = "http://159.89.185.155:3000/api/publishers/find";
        PublisherQuery query = new PublisherQuery();
        query.setQ(new Query(site.getId()));
        HttpEntity<PublisherQuery> entity = new HttpEntity<PublisherQuery>(query, headers);

        PublisherResponse result = null;

        try {
            result = this.restTemplate.postForObject(uri, entity, PublisherResponse.class);
        }catch (HttpServerErrorException  | HttpClientErrorException | CompletionException ex) {
            throw new PublisherNotFoundException("Publisher Id not found", site.getId());
        }

        return result != null? CompletableFuture.completedFuture(result.getPublisher()):null;
    }
}
