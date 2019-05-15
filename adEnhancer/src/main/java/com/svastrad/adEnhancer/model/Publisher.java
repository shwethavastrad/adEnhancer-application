package com.svastrad.adEnhancer.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Publisher {

    @JsonProperty("id")
    @NotEmpty(message = "Publisher Id was not found")
    @Id
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

}