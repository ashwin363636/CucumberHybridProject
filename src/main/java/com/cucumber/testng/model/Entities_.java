
package com.cucumber.testng.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Entities_ {
    Description DescriptionObject;


    // Getter Methods

    public Description getDescription() {
        return DescriptionObject;
    }

    // Setter Methods

    public void setDescription(Description descriptionObject) {
        this.DescriptionObject = descriptionObject;
    }
}