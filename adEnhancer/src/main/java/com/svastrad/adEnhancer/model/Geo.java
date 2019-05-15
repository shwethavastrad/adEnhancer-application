package com.svastrad.adEnhancer.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "country"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Geo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @JsonProperty("country")
    private String country;

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

}
