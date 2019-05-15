package com.svastrad.adEnhancer;

import com.svastrad.adEnhancer.model.HelloObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @GetMapping("/hello")
    public HelloObject getHelloWordObject() {
        HelloObject hello = new HelloObject();
        hello.setMessage("Hi there! instance id: " + instanceId);
        return hello;
    }
}