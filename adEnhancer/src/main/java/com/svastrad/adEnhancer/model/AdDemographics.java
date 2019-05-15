package com.svastrad.adEnhancer.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "female_percent",
        "male_percent"
})
@Entity
public class AdDemographics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @JsonProperty("female_percent")
    private Integer femalePercent;
    @JsonProperty("male_percent")
    private Integer malePercent;

    @JsonProperty("female_percent")
    public Integer getFemalePercent() {
        return femalePercent;
    }

    @JsonProperty("female_percent")
    public void setFemalePercent(Integer femalePercent) {
        this.femalePercent = femalePercent;
    }

    @JsonProperty("male_percent")
    public Integer getMalePercent() {
        return malePercent;
    }

    @JsonProperty("male_percent")
    public void setMalePercent(Integer malePercent) {
        this.malePercent = malePercent;
    }

}
