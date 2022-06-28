package com.techelevator.weatherapi.model.alerts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlertResponse {

    private String type;
    private String title;
    private String updated;
    private Feature[] features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Feature[] getFeatures() {
        return features;
    }

    public void setFeatures(Feature[] features) {
        this.features = features;
    }
}
