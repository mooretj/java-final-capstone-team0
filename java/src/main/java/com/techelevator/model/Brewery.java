package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalTime;

public class Brewery {
    @JsonProperty("brewery_id")
    private int id;
    @JsonProperty("brewery_name")
    private String breweryName;
    private String website;
    @JsonProperty("open_hour")
    private LocalTime openHour;
    @JsonProperty("close_hour")
    private LocalTime closeHour;
    @JsonProperty("history")
    private String history;

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public LocalTime getOpenHour() {
        return openHour;
    }

    public void setOpenHour(LocalTime openHour) {
        this.openHour = openHour;
    }

    public LocalTime getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(LocalTime closeHour) {
        this.closeHour = closeHour;
    }

    public Brewery(int id, String breweryName, String website, LocalTime openHour, LocalTime closeHour, String history) {
        this.id = id;
        this.breweryName = breweryName;
        this.website = website;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.history = history;
    }

    public Brewery() {}

    @Override
    public String toString() {
        return "Brewery{" +
                "id=" + id +
                ", Brewery Name='" + breweryName + '\'' +
                ", Website=" + website +
                ", Open Hour=" + openHour +
                ", Close Hour=" + closeHour +
                ", History=" + history +
                '}';
    }
}
