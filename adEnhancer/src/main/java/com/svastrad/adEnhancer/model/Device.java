package com.svastrad.adEnhancer.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ip",
        "geo"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @JsonProperty("ip")
    @NotEmpty(message = "Device.ip cannot be empty")
    private String ip;

    @JsonProperty("geo")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Geo.class)
    private Geo geo;

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("geo")
    public Geo getGeo() {
        return geo;
    }

    @JsonProperty("geo")
    public void setGeo(Geo geo) {
        this.geo = geo;
    }

}
