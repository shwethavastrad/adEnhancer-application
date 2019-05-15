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
        "id",
        "current_time",
        "gmt_offset",
        "code",
        "is_daylight_saving"
})
public class TimeZone {

    @JsonProperty("id")
    private String id;
    @JsonProperty("current_time")
    private String currentTime;
    @JsonProperty("gmt_offset")
    private Integer gmtOffset;
    @JsonProperty("code")
    private String code;
    @JsonProperty("is_daylight_saving")
    private Boolean isDaylightSaving;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("current_time")
    public String getCurrentTime() {
        return currentTime;
    }

    @JsonProperty("current_time")
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    @JsonProperty("gmt_offset")
    public Integer getGmtOffset() {
        return gmtOffset;
    }

    @JsonProperty("gmt_offset")
    public void setGmtOffset(Integer gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("is_daylight_saving")
    public Boolean getIsDaylightSaving() {
        return isDaylightSaving;
    }

    @JsonProperty("is_daylight_saving")
    public void setIsDaylightSaving(Boolean isDaylightSaving) {
        this.isDaylightSaving = isDaylightSaving;
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
