package com.svastrad.adEnhancer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.svastrad.adEnhancer.model.AdRequest;
import com.svastrad.adEnhancer.service.AdEnhanceService;
import com.svastrad.adEnhancer.service.PublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;


@RestController
@Validated
@EnableCircuitBreaker
public class AdEnhanceController {
    private static final Logger logger = LoggerFactory.getLogger(AdEnhanceController.class);

    @Autowired
    private AdEnhanceService adEnhanceService;

    @PostMapping("/enhance")

    public ResponseEntity<AdRequest> enhanceAdRequest(@Valid @RequestBody AdRequest request) {


        AdRequest response = null;
        try {
            response = adEnhanceService.enhance(request);
        } catch (ExecutionException | InterruptedException e) {
            logger.error(e.getStackTrace().toString());
        }

        if (response == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<AdRequest> fallback(AdRequest request, Throwable hystrixCommand) {
        return ResponseEntity.ok(request);
    }
}
