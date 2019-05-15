package com.svastrad.adEnhancer.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "site",
        "device",
        "user"
})
@Entity
public class AdRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @JsonProperty("site")
    @Valid
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Site.class)
    private Site site;

    @JsonProperty("device")
    @Valid
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Device.class)
    private Device device;

    @JsonProperty("user")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Device.class)
    private User user;

    @JsonProperty("site")
    public Site getSite() {
        return site;
    }

    @JsonProperty("site")
    public void setSite(Site site) {
        this.site = site;
    }

    @JsonProperty("device")
    public Device getDevice() {
        return device;
    }

    @JsonProperty("device")
    public void setDevice(Device device) {
        this.device = device;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

}
