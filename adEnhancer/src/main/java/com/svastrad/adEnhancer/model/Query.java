package com.svastrad.adEnhancer.model;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "siteID"
})
public class Query {

    @JsonProperty("siteID")
    private String siteID;


    @JsonProperty("siteID")
    public String getSiteID() {
        return siteID;
    }

    @JsonProperty("siteID")
    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }


    public Query(String siteID) {
        this.siteID = siteID;
    }
}