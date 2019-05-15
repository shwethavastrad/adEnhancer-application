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
        "asn",
        "isp"
})
public class Connection {

    @JsonProperty("asn")
    private Integer asn;
    @JsonProperty("isp")
    private String isp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("asn")
    public Integer getAsn() {
        return asn;
    }

    @JsonProperty("asn")
    public void setAsn(Integer asn) {
        this.asn = asn;
    }

    @JsonProperty("isp")
    public String getIsp() {
        return isp;
    }

    @JsonProperty("isp")
    public void setIsp(String isp) {
        this.isp = isp;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
