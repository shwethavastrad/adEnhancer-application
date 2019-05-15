package com.svastrad.adEnhancer;

import com.svastrad.adEnhancer.model.AdRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="ad-enhancer-service")
@RibbonClient(name="ad-enhancer-service")
public interface AdEnhancerProxy {
    @PostMapping("/enhance")
    public AdRequest enhanceAdRequest
            (@RequestBody AdRequest request);
}
