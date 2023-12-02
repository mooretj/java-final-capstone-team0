package com.techelevator.model;

public class Beer {

    private int id;
    private int brewery_id;
    private String name;
    private String imgUrl;
    private String description;
    private double abv;
    private String type;
    private boolean isAvailable;

    public Beer() { }

    public Beer(int id, int brewery_id, String name, String imgUrl,
                String description, double abv, String type, boolean isAvailable) {
        this.id = id;
        this.brewery_id = brewery_id;
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

    public int getBrewery_id() {
        return brewery_id;
    }

    public void setBrewery_id(int brewery_id) {
        this.brewery_id = brewery_id;
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
                 "id=" + id +
                ", brewery_id=" + brewery_id +
                ", name='" + name + '\'' +
                ", img_url='" + imgUrl + '\'' +
                ", description='" + description + '\'' +
                ", abv=" + abv + '\'' +
                ", type='" + type + '\'' +
                ", is_available=" + isAvailable;
    }
}
