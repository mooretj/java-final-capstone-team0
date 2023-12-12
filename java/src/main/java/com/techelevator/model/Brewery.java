package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalTime;

public class Brewery {
    @JsonProperty("brewery_id")
    private int id;
    @JsonProperty("brewery_name")
    private String breweryName;
    @JsonProperty("brewery_main_img")
    private String breweryImg;

    @JsonProperty("brewery_logo_img")
    private String breweryLogoImg;
    @JsonProperty("website")
    private String website;
    @JsonProperty("brewery_hours")
    private Hours hours;
    @JsonProperty("history")
    private String history;
    @JsonProperty("brewery_contact")
    private Contact contact;

    public String getBreweryImg() {
        return breweryImg;
    }

    public void setBreweryImg(String breweryImg) {
        this.breweryImg = breweryImg;
    }

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

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getBreweryLogoImg() {
        return breweryLogoImg;
    }

    public void setBreweryLogoImg(String breweryLogoImg) {
        this.breweryLogoImg = breweryLogoImg;
    }

    public Brewery(int id, String breweryName, String breweryImg, String breweryLogoImg, String website, Hours hours, String history, Contact contact) {
        this.id = id;
        this.breweryName = breweryName;
        this.breweryImg = breweryImg;
        this.breweryLogoImg = breweryLogoImg;
        this.website = website;
        this.hours = hours;
        this.history = history;
        this.contact = contact;
    }

    public Brewery() {}

    @Override
    public String toString() {
        return "Brewery{" +
                "id=" + id +
                ", Brewery Name='" + breweryName +
                ", Brewery Img =" + breweryImg +
                ", Brewery Logo Img =" + breweryLogoImg +
                ", Website=" + website +
                ", Hours=" + hours +
                ", History=" + history +
                ", Contact Info=Email: " + contact.getEmail() +
                " Phone: " + contact.getPhone() + " Address: " + contact.getAddress() +
                '}';
    }
}
