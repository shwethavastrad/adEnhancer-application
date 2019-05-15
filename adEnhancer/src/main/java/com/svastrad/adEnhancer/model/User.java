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
        "id"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class User {

    @JsonProperty("id")
    @Id
    private String id;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }


}