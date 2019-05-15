package com.svastrad.adEnhancer.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.svastrad.adEnhancer.model.Query;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "q"
})
public class PublisherQuery {

    @JsonProperty("q")
    private Query q;


    @JsonProperty("q")
    public Query getQ() {
        return q;
    }

    @JsonProperty("q")
    public void setQ(Query q) {
        this.q = q;
    }



}