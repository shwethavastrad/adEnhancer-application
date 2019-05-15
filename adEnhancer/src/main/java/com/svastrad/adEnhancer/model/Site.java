package com.svastrad.adEnhancer.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "page",
        "demographics",
        "publisher"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Site {

    @JsonProperty("id")
    @NotNull(message = "Site.id cannot be blank")
    @Id
    private String id;

    @JsonProperty("page")
    @NotNull(message = "Site.page cannot be blank")
    private String page;

    @JsonProperty("demographics")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = AdDemographics.class)
    private AdDemographics demographics;

    @JsonProperty("publisher")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Publisher.class)
    private Publisher publisher;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("page")
    public String getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(String page) {
        this.page = page;
    }

    @JsonProperty("demographics")
    public AdDemographics getDemographics() {
        return demographics;
    }

    @JsonProperty("demographics")
    public void setDemographics(AdDemographics demographics) {
        this.demographics = demographics;
    }

    @JsonProperty("publisher")
    public Publisher getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

}
