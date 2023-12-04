package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Beer {

    @JsonProperty("beer_id")
    private int id;
    @JsonProperty("brewery_id")
    private int breweryId;
    @JsonProperty("beer_name")
    private String name;
    @JsonProperty("beer_img")
    private String imgUrl;
    @JsonProperty("beer_description")
    private String description;
    @JsonProperty("abv")
    private double abv;
    @JsonProperty("beer_type")
    private String type;
    @JsonProperty("is_available")
    private boolean isAvailable;

    public Beer() { }

    public Beer(int id, int breweryId, String name, String imgUrl,
                String description, double abv, String type, boolean isAvailable) {
        this.id = id;
        this.breweryId = breweryId;
        this.name = name;
        this.imgUrl = imgUrl;
        this.description = description;
        this.abv = abv;
        this.type = type;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Beer{" +
                 "Id=" + id +
                ", Brewery Id=" + breweryId +
                ", Name='" + name + '\'' +
                ", Img Url='" + imgUrl + '\'' +
                ", Description='" + description + '\'' +
                ", ABV=" + abv + '\'' +
                ", Type='" + type + '\'' +
                ", Is Available=" + isAvailable;
    }
}
