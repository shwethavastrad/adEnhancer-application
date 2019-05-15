package com.svastrad.adEnhancer.service;

import com.svastrad.adEnhancer.error.PublisherNotFoundException;
import com.svastrad.adEnhancer.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

@Service
public class AdEnhanceService {
    private static final Logger logger = LoggerFactory.getLogger(AdEnhanceService.class);
    @Autowired private PublisherService publisherService;
    @Autowired private DemographicsService demographicsService;
    @Autowired private GeoService geoService;


    public AdRequest enhance(@Valid AdRequest request) throws ExecutionException, InterruptedException, PublisherNotFoundException {
        long start = System.currentTimeMillis();

        try {

            CompletableFuture<Publisher> publisher = publisherService.injectPublisher(request.getSite());
            CompletableFuture<Demographics> demographics = demographicsService.injectDemographics(request.getSite());
            CompletableFuture<Geo> geo = geoService.injectCountry(request.getDevice());

            CompletableFuture.allOf(publisher, demographics, geo).join();

            if (geo != null) {
                request.getDevice().setGeo(geo.get());
            }
            if (publisher != null && publisher.get() != null && publisher.get().getId() != null) {
                request.getSite().setPublisher(publisher.get());
            } else {
                throw new PublisherNotFoundException("Publisher Id not found", request.getSite().getPage());
            }
            if (demographics != null && demographics.get() != null) {
                AdDemographics adDemographics = new AdDemographics();
                Integer femalePercent = demographics.get().getPctFemale();
                adDemographics.setFemalePercent(femalePercent);
                adDemographics.setMalePercent(100 - femalePercent);
                request.getSite().setDemographics(adDemographics);
            }
        }catch (PublisherNotFoundException | CompletionException ex) {
            throw new PublisherNotFoundException("Publisher Id not found", request.getSite().getPage());
        }
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        return request;
    }
}
