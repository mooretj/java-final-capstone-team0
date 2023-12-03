package com.techelevator.model;

import java.time.LocalTime;

public class Brewery {
    private int id;
    private String breweryName;
    private String webSite;
    private LocalTime openHour;
    private LocalTime closeHour;
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

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
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

    public Brewery(int Id, String breweryName, String webSite, LocalTime openHour, LocalTime closeHour, String history) {
        this.id = id;
        this.breweryName = breweryName;
        this.webSite = webSite;
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
                ", Website=" + webSite +
                ", Open Hour=" + openHour +
                ", Close Hour=" + closeHour +
                ", History=" + history +
                '}';
    }
}
